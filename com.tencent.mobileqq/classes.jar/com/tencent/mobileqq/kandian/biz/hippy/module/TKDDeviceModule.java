package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView;
import com.tencent.mobileqq.kandian.biz.hippy.entity.AccountInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJUGJsonUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

@HippyNativeModule(name="TKDDeviceModule")
public class TKDDeviceModule
  extends HippyNativeModuleBase
{
  private static float sHardwareCodecLevel = -1.0F;
  
  public TKDDeviceModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private static String getApnType()
  {
    int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    if (1 == i) {
      return "wifi";
    }
    if (2 == i) {
      return "2g";
    }
    if (3 == i) {
      return "3g";
    }
    if (4 == i) {
      return "4g";
    }
    if (6 == i) {
      return "5g";
    }
    return "";
  }
  
  public static HippyMap getDeviceInfo()
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("guid", TKDAccountModule.getCurAccountInfo().qqNum);
    localHippyMap.pushString("qua", RIJUGJsonUtils.c());
    localHippyMap.pushString("qua2", RIJUGJsonUtils.c());
    localHippyMap.pushString("macAddress", DeviceInfoUtil.d(BaseApplicationImpl.getApplication().getApplicationContext()));
    localHippyMap.pushString("networkType", getApnType());
    localHippyMap.pushString("id", DeviceInfoUtil.j());
    localHippyMap.pushString("qimei", UserAction.getQIMEI());
    localHippyMap.pushString("dpi", String.valueOf(ViewUtils.getDensityDpi()));
    localHippyMap.pushBoolean("isKingCardUser", HippyTKDListView.isKingCardMobileNetWork());
    return localHippyMap;
  }
  
  @Nullable
  private qq_ad_get.QQAdGet.DeviceInfo getGdtDeviceInfo()
  {
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).a = "ce2d9f";
    localObject = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
    if (localObject != null) {
      return ((GdtDeviceInfoHelper.Result)localObject).a;
    }
    return null;
  }
  
  public static String getHardWareCodecLevel()
  {
    float f = sHardwareCodecLevel;
    if (f > 0.0F) {
      return String.valueOf(f);
    }
    for (;;)
    {
      int i;
      int m;
      try
      {
        Object localObject1 = Class.forName("android.media.MediaCodecList");
        Object localObject3 = ((Class)localObject1).getDeclaredMethod("getCodecCount", new Class[0]);
        i = 1;
        localObject1 = ((Class)localObject1).getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        Object localObject2 = Class.forName("android.media.MediaCodecInfo");
        Method localMethod1 = ((Class)localObject2).getDeclaredMethod("getSupportedTypes", new Class[0]);
        ((Class)localObject2).getDeclaredMethod("getName", new Class[0]);
        Method localMethod2 = ((Class)localObject2).getDeclaredMethod("isEncoder", new Class[0]);
        localObject2 = ((Class)localObject2).getDeclaredMethod("getCapabilitiesForType", new Class[] { String.class });
        Field localField1 = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getDeclaredField("profileLevels");
        Field localField2 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel").getDeclaredField("level");
        int i2 = ((Integer)((Method)localObject3).invoke(null, new Object[0])).intValue();
        int k = 0;
        f = -1.0F;
        j = -1;
        m = 0;
        if (k < i2)
        {
          localObject3 = new Object[i];
          localObject3[0] = Integer.valueOf(k);
          localObject3 = ((Method)localObject1).invoke(null, (Object[])localObject3);
          if (((Boolean)localMethod2.invoke(localObject3, new Object[0])).booleanValue()) {
            break label394;
          }
          String[] arrayOfString = (String[])localMethod1.invoke(localObject3, new Object[0]);
          int n = arrayOfString.length;
          if (m >= n) {
            break label394;
          }
          if (arrayOfString[m].equalsIgnoreCase("video/hevc"))
          {
            n = 1;
            localObject3 = (Object[])localField1.get(((Method)localObject2).invoke(localObject3, new Object[] { "video/hevc" }));
            int i3 = localObject3.length;
            i = 0;
            if (i < i3)
            {
              int i1 = ((Integer)localField2.get(localObject3[i])).intValue();
              m = j;
              if (i1 <= j) {
                break label397;
              }
              m = i1;
              break label397;
            }
            f = innerCalculateRealLevel(j);
            i = n;
          }
          else
          {
            i = 1;
            m += 1;
            continue;
          }
          k += 1;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        f = 0.0F;
      }
      sHardwareCodecLevel = f;
      return "";
      label394:
      continue;
      label397:
      i += 1;
      int j = m;
    }
  }
  
  private static float innerCalculateRealLevel(int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
      int i = ((Integer)localClass.getField("HEVCHighTierLevel1").get(null)).intValue();
      int j = ((Integer)localClass.getField("HEVCHighTierLevel2").get(null)).intValue();
      int k = ((Integer)localClass.getField("HEVCHighTierLevel21").get(null)).intValue();
      int m = ((Integer)localClass.getField("HEVCHighTierLevel3").get(null)).intValue();
      int n = ((Integer)localClass.getField("HEVCHighTierLevel31").get(null)).intValue();
      int i1 = ((Integer)localClass.getField("HEVCHighTierLevel4").get(null)).intValue();
      int i2 = ((Integer)localClass.getField("HEVCHighTierLevel41").get(null)).intValue();
      int i3 = ((Integer)localClass.getField("HEVCHighTierLevel5").get(null)).intValue();
      int i4 = ((Integer)localClass.getField("HEVCHighTierLevel51").get(null)).intValue();
      int i5 = ((Integer)localClass.getField("HEVCHighTierLevel52").get(null)).intValue();
      int i6 = ((Integer)localClass.getField("HEVCHighTierLevel6").get(null)).intValue();
      int i7 = ((Integer)localClass.getField("HEVCHighTierLevel61").get(null)).intValue();
      int i8 = ((Integer)localClass.getField("HEVCHighTierLevel62").get(null)).intValue();
      int i9 = ((Integer)localClass.getField("HEVCMainTierLevel1").get(null)).intValue();
      int i10 = ((Integer)localClass.getField("HEVCMainTierLevel2").get(null)).intValue();
      int i11 = ((Integer)localClass.getField("HEVCMainTierLevel21").get(null)).intValue();
      int i12 = ((Integer)localClass.getField("HEVCMainTierLevel3").get(null)).intValue();
      int i13 = ((Integer)localClass.getField("HEVCMainTierLevel31").get(null)).intValue();
      int i14 = ((Integer)localClass.getField("HEVCMainTierLevel4").get(null)).intValue();
      int i15 = ((Integer)localClass.getField("HEVCMainTierLevel41").get(null)).intValue();
      int i16 = ((Integer)localClass.getField("HEVCMainTierLevel5").get(null)).intValue();
      int i17 = ((Integer)localClass.getField("HEVCMainTierLevel51").get(null)).intValue();
      int i18 = ((Integer)localClass.getField("HEVCMainTierLevel52").get(null)).intValue();
      int i19 = ((Integer)localClass.getField("HEVCMainTierLevel6").get(null)).intValue();
      int i20 = ((Integer)localClass.getField("HEVCMainTierLevel61").get(null)).intValue();
      int i21 = ((Integer)localClass.getField("HEVCMainTierLevel62").get(null)).intValue();
      if ((paramInt != i) && (paramInt != i9))
      {
        if ((paramInt != j) && (paramInt != i10))
        {
          if ((paramInt != k) && (paramInt != i11))
          {
            if ((paramInt != m) && (paramInt != i12))
            {
              if ((paramInt != n) && (paramInt != i13))
              {
                if ((paramInt != i1) && (paramInt != i14))
                {
                  if ((paramInt != i2) && (paramInt != i15))
                  {
                    if ((paramInt != i3) && (paramInt != i16))
                    {
                      if ((paramInt != i4) && (paramInt != i17))
                      {
                        if ((paramInt != i5) && (paramInt != i18))
                        {
                          if ((paramInt != i6) && (paramInt != i19))
                          {
                            if ((paramInt < i7) && (paramInt != i20))
                            {
                              if ((paramInt >= i8) || (paramInt == i21)) {
                                return 6.2F;
                              }
                            }
                            else {
                              return 6.1F;
                            }
                          }
                          else {
                            return 6.0F;
                          }
                        }
                        else {
                          return 5.2F;
                        }
                      }
                      else {
                        return 5.1F;
                      }
                    }
                    else {
                      return 5.0F;
                    }
                  }
                  else {
                    return 4.1F;
                  }
                }
                else {
                  return 4.0F;
                }
              }
              else {
                return 3.1F;
              }
            }
            else {
              return 3.0F;
            }
          }
          else {
            return 2.1F;
          }
        }
        else {
          return 2.0F;
        }
      }
      else {
        return 1.0F;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0.0F;
  }
  
  @HippyMethod(name="getDeviceInfo")
  public void getDeviceInfo(Promise paramPromise)
  {
    paramPromise.resolve(getDeviceInfo());
  }
  
  @HippyMethod(name="getHWCodecLevel")
  public void getHWCodecLevel(Promise paramPromise)
  {
    paramPromise.resolve(getHardWareCodecLevel());
  }
  
  @HippyMethod(name="getOAID")
  public void getOAID(Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = getGdtDeviceInfo();
    if (localDeviceInfo != null) {
      localHippyMap.pushString("oaid", localDeviceInfo.oaid.get());
    }
    paramPromise.resolve(localHippyMap);
  }
  
  @HippyMethod(name="getQADID")
  public void getQADID(Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = getGdtDeviceInfo();
    if (localDeviceInfo != null) {
      localHippyMap.pushString("qadid", localDeviceInfo.qadid.get());
    }
    paramPromise.resolve(localHippyMap);
  }
  
  @HippyMethod(name="getQAID")
  public void getQAID(Promise paramPromise)
  {
    paramPromise.resolve(new HippyMap());
  }
  
  @HippyMethod(name="getTAID")
  public void getTAID(Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = getGdtDeviceInfo();
    if (localDeviceInfo != null) {
      localHippyMap.pushString("taid", localDeviceInfo.taid_ticket.get());
    }
    paramPromise.resolve(localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDDeviceModule
 * JD-Core Version:    0.7.0.1
 */