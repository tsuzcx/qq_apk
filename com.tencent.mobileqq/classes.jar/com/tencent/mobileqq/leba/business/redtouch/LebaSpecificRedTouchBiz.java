package com.tencent.mobileqq.leba.business.redtouch;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyNotifyRedTouchInfo;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyManager;
import com.tencent.mobileqq.leba.business.ILebaRedTouchBiz;
import com.tencent.mobileqq.leba.entity.LebaExposureInfo;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class LebaSpecificRedTouchBiz
  extends ILebaRedTouchBiz
{
  public static int c = -1;
  protected boolean b;
  private int d = 0;
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return;
    }
    if (paramAppInfo.iNewFlag.get() == 0) {
      return;
    }
    if (paramString.equals("com.tx.xingqubuluo.android"))
    {
      int i;
      if (!TextUtils.isEmpty(paramAppInfo.icon_url.get())) {
        i = 1;
      } else {
        i = 2;
      }
      paramString = new StringBuilder();
      paramString.append(i);
      paramString.append("");
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_tribe", "", "dynamic", "exp_tribe", 0, 0, paramString.toString(), "", "", "");
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext, RedTouch paramRedTouch)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject1 = (IReadInJoyManager)paramQQAppInterface.getRuntimeService(IReadInJoyManager.class);
      if (localObject1 != null)
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((IReadInJoyManager)localObject1).obtainCachedRedTypeInfo();
        paramQQAppInterface = ((IReadInJoyManager)localObject1).obtainCachedAppInfo();
        localObject1 = ((IReadInJoyManager)localObject1).obtainLatestNotifyRedTouchInfo();
        int i = ((ReadInJoyNotifyRedTouchInfo)localObject1).b;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4) {
                  return;
                }
                paramContext = ((ReadInJoyNotifyRedTouchInfo)localObject1).c;
                localObject1 = localRedTypeInfo.red_content;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(paramContext);
                ((StringBuilder)localObject2).append("");
                ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
                localRedTypeInfo.red_type.set(4);
                localRedTypeInfo.red_desc.set("{'cr':'#FF0000'}");
                paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
                paramQQAppInterface.iNewFlag.set(1);
                paramRedTouch.a(paramQQAppInterface);
                return;
              }
              localRedTypeInfo.red_type.set(3);
              i = ((ReadInJoyNotifyRedTouchInfo)localObject1).e;
              paramContext = localRedTypeInfo.red_desc;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("{'drawable':");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append("}");
              paramContext.set(((StringBuilder)localObject1).toString());
              paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
              paramQQAppInterface.iNewFlag.set(1);
              paramRedTouch.a(paramQQAppInterface);
              return;
            }
            localObject1 = ((ReadInJoyNotifyRedTouchInfo)localObject1).c;
            Object localObject2 = localRedTypeInfo.red_content;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("");
            ((PBStringField)localObject2).set(localStringBuilder.toString());
            localRedTypeInfo.red_type.set(4);
            localRedTypeInfo.red_desc.set("{'cr':'#777777'}");
            paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
            localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            localRedTypeInfo.red_type.set(9);
            localObject1 = localRedTypeInfo.red_content;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(DisplayUtil.a(paramContext, 3.0F));
            ((StringBuilder)localObject2).append("");
            ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
            localRedTypeInfo.red_desc.set("");
            paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
            paramContext = new BusinessInfoCheckUpdate.RedTypeInfo();
            paramContext.red_type.set(0);
            paramQQAppInterface.red_display_info.red_type_info.add(paramContext);
            paramQQAppInterface.iNewFlag.set(1);
            paramRedTouch.a(paramQQAppInterface);
            return;
          }
          i = ((ReadInJoyNotifyRedTouchInfo)localObject1).d;
          if (i > 99)
          {
            localRedTypeInfo.red_content.set("99+");
          }
          else
          {
            paramContext = localRedTypeInfo.red_content;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("");
            paramContext.set(((StringBuilder)localObject1).toString());
          }
          localRedTypeInfo.red_type.set(5);
          localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
          paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
          paramQQAppInterface.iNewFlag.set(1);
          paramRedTouch.a(paramQQAppInterface);
          return;
        }
        paramRedTouch.g();
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, RedTouch paramRedTouch)
  {
    if (paramQQAppInterface != null)
    {
      if (ConfessConfig.a(paramQQAppInterface, "redpoint_leba_show"))
      {
        paramContext = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).d();
        if (paramContext != null) {
          paramQQAppInterface = paramContext.a(paramQQAppInterface);
        } else {
          paramQQAppInterface = "";
        }
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!this.b))
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramContext = new BusinessInfoCheckUpdate.AppInfo();
          localRedTypeInfo.red_content.set(paramQQAppInterface);
          localRedTypeInfo.red_type.set(4);
          localRedTypeInfo.red_desc.set("{'cn':'#00000000','cr':'#888888'}");
          paramContext.red_display_info.red_type_info.add(localRedTypeInfo);
          paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramQQAppInterface.red_type.set(0);
          paramQQAppInterface.red_desc.set("");
          paramQQAppInterface.red_content.set("");
          paramContext.red_display_info.red_type_info.add(paramQQAppInterface);
          paramContext.iNewFlag.set(1);
          paramRedTouch.a(paramContext);
          try
          {
            paramQQAppInterface = (TextView)paramRedTouch.findViewById(30);
            paramContext = (LinearLayout.LayoutParams)paramQQAppInterface.getLayoutParams();
            paramQQAppInterface.setMaxWidth(ViewUtils.dip2px(200.0F));
            paramContext.weight = 1.0F;
            paramContext.width = 0;
            paramContext.rightMargin = ViewUtils.dip2px(4.0F);
            paramQQAppInterface.setEllipsize(TextUtils.TruncateAt.END);
            paramQQAppInterface.setLayoutParams(paramContext);
            return;
          }
          catch (Exception paramQQAppInterface)
          {
            QLog.i("LebaSpecificRedTouchBiz", 1, "updateConfessRedTouch", paramQQAppInterface);
            return;
          }
        }
        paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramContext = new BusinessInfoCheckUpdate.AppInfo();
        paramQQAppInterface.red_type.set(0);
        paramQQAppInterface.red_desc.set("");
        paramQQAppInterface.red_content.set("");
        paramContext.red_display_info.red_type_info.add(paramQQAppInterface);
        paramContext.iNewFlag.set(1);
        paramRedTouch.a(paramContext);
        return;
      }
      paramRedTouch.g();
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, INearbyRedInfo paramINearbyRedInfo, RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return;
    }
    c = paramINearbyRedInfo.getRedAppIdType();
    this.d = paramINearbyRedInfo.getRedPointReportType();
    int i = paramINearbyRedInfo.getRedType();
    if (i != 0)
    {
      if (i != 3)
      {
        Object localObject;
        if (i != 5)
        {
          if (i != 11)
          {
            paramRedTouch.a(null);
            return;
          }
          if (!this.b)
          {
            paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
            paramQQAppInterface.red_type.set(0);
            paramQQAppInterface.red_content.set("");
            paramQQAppInterface.red_desc.set("");
            paramRedTouch.a(paramQQAppInterface);
            return;
          }
          paramQQAppInterface = new BusinessInfoCheckUpdate.AppInfo();
          localObject = paramQQAppInterface.iNewFlag;
          int j = 1;
          ((PBInt32Field)localObject).set(1);
          paramQQAppInterface.exposure_max.set(1);
          localObject = new BusinessInfoCheckUpdate.RedDisplayInfo();
          if ((!TextUtils.isEmpty(paramINearbyRedInfo.getCornerInfo())) || (!TextUtils.isEmpty(paramINearbyRedInfo.getTipTextInfo())))
          {
            BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            if (!TextUtils.isEmpty(paramINearbyRedInfo.getCornerInfo()))
            {
              localRedTypeInfo.red_type.set(11);
              localRedTypeInfo.red_content.set(paramINearbyRedInfo.getCornerInfo());
              ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(localRedTypeInfo);
              i = 1;
            }
            else
            {
              i = 0;
            }
            if (!TextUtils.isEmpty(paramINearbyRedInfo.getTipTextInfo()))
            {
              localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
              localRedTypeInfo.red_type.set(-100);
              localRedTypeInfo.red_content.set(paramINearbyRedInfo.getTipTextInfo());
              ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(localRedTypeInfo);
            }
            else
            {
              j = 0;
            }
            if ((i == 0) && (j != 0))
            {
              paramINearbyRedInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
              paramINearbyRedInfo.red_type.set(0);
              ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(paramINearbyRedInfo);
            }
            paramQQAppInterface.red_display_info.set((MessageMicro)localObject);
            paramRedTouch.b(paramQQAppInterface);
          }
        }
        else
        {
          localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(5);
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(paramINearbyRedInfo.getRedNum());
          paramQQAppInterface.append("");
          paramQQAppInterface = paramQQAppInterface.toString();
          if (paramINearbyRedInfo.getRedNum() > 99) {
            paramQQAppInterface = "99+";
          }
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set(paramQQAppInterface);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("{'cn':'#FF0000'}");
          paramRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
        }
      }
      else
      {
        if (this.b)
        {
          paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramQQAppInterface.red_type.set(0);
          paramQQAppInterface.red_content.set("");
          paramQQAppInterface.red_desc.set("");
          paramRedTouch.a(paramQQAppInterface);
          return;
        }
        paramQQAppInterface = (String)paramINearbyRedInfo.getRedUrl().get(0);
        paramINearbyRedInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramINearbyRedInfo.red_type.set(3);
        paramINearbyRedInfo.red_content.set(paramQQAppInterface);
        paramINearbyRedInfo.red_desc.set("{'av':1, 'dot':1}");
        paramRedTouch.a(paramINearbyRedInfo);
      }
    }
    else
    {
      paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramQQAppInterface.red_type.set(0);
      paramQQAppInterface.red_content.set("");
      paramQQAppInterface.red_desc.set("");
      paramRedTouch.a(paramQQAppInterface);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return;
    }
    paramQQAppInterface = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    oidb_0x791.RedDotInfo localRedDotInfo = paramQQAppInterface.q();
    if (localRedDotInfo == null)
    {
      paramRedTouch.g();
      return;
    }
    StoryReportor.a("dynamic", "exp_story", 0, paramQQAppInterface.r(), new String[0]);
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    int j = localRedDotInfo.uint32_appid.get();
    int i = 4;
    if (j != 8)
    {
      Object localObject;
      if (j != 11)
      {
        if (j != 35)
        {
          if (j != 37)
          {
            if (j == 52)
            {
              localObject = localRedTypeInfo.red_content;
              if (localRedDotInfo.uint32_number.get() > 99)
              {
                paramQQAppInterface = "99+";
              }
              else
              {
                paramQQAppInterface = new StringBuilder();
                paramQQAppInterface.append(localRedDotInfo.uint32_number.get());
                paramQQAppInterface.append("");
                paramQQAppInterface = paramQQAppInterface.toString();
              }
              ((PBStringField)localObject).set(paramQQAppInterface);
              localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
              break label641;
            }
          }
          else
          {
            try
            {
              paramQQAppInterface = new JSONObject(localRedDotInfo.str_custom_buffer.get().toStringUtf8()).getString("red_word");
            }
            catch (Exception paramQQAppInterface)
            {
              SLog.d("LebaSpecificRedTouchBiz", "tag red dot json parse error , %s", new Object[] { paramQQAppInterface.getMessage() });
              paramQQAppInterface = "New";
            }
            localRedTypeInfo.red_content.set(paramQQAppInterface);
            localRedTypeInfo.red_desc.set("{'cn':'#00000000' ,'cr':'#777777'}");
            break label641;
          }
        }
        else
        {
          paramQQAppInterface = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            try
            {
              long l = new JSONObject(paramQQAppInterface).optLong("image_red_display_780", 1L);
              SLog.e("LebaSpecificRedTouchBiz", "updateStoryRedTouch() APPID_STORY_IMG: red display=%d", new Object[] { Long.valueOf(l) });
              if (l != 0L) {
                break label365;
              }
              paramRedTouch.g();
            }
            catch (JSONException paramQQAppInterface)
            {
              SLog.c("LebaSpecificRedTouchBiz", "updateStoryRedTouch() APPID_STORY_IMG: Error parse json: ", paramQQAppInterface);
            }
          } else {
            SLog.b("LebaSpecificRedTouchBiz", "updateStoryRedTouch() APPID_STORY_IMG: str_custom_buffer is null");
          }
          label365:
          i = localRedDotInfo.uint32_cmd_uin_type.get();
          if (i == 0)
          {
            localObject = localRedDotInfo.str_face_url.get().toStringUtf8();
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(localRedDotInfo.uint64_cmd_uin.get());
            paramQQAppInterface.append("");
            paramQQAppInterface = String.format("{'uin':'%s','dot':1, 'av':1}", new Object[] { paramQQAppInterface.toString() });
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localRedTypeInfo.red_content.set((String)localObject);
              paramQQAppInterface = "{'av':1, 'dot':1}";
            }
            localRedTypeInfo.red_desc.set(paramQQAppInterface);
          }
          else
          {
            if (i != 1) {
              break label572;
            }
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("https://p.qlogo.cn/gh/");
            paramQQAppInterface.append(localRedDotInfo.uint64_cmd_uin.get());
            paramQQAppInterface.append("/");
            paramQQAppInterface.append(localRedDotInfo.uint64_cmd_uin.get());
            paramQQAppInterface.append("/100?t=");
            paramQQAppInterface.append(TroopRedTouchManager.f);
            paramQQAppInterface = paramQQAppInterface.toString();
            localRedTypeInfo.red_content.set(paramQQAppInterface);
            localRedTypeInfo.red_desc.set("{'av':1, 'dot':1}");
          }
          i = 3;
          break label641;
        }
        label572:
        i = -1;
      }
      else
      {
        paramQQAppInterface = localRedTypeInfo.red_content;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localRedDotInfo.str_custom_buffer.get().toStringUtf8());
        ((StringBuilder)localObject).append("");
        paramQQAppInterface.set(((StringBuilder)localObject).toString());
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      }
    }
    else
    {
      i = 0;
    }
    label641:
    if (i == -1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("更新动态红点:");
      paramQQAppInterface.append(TroopRedTouchManager.b(localRedDotInfo));
      QLog.i("storyRedDotDebug", 2, paramQQAppInterface.toString());
    }
    localRedTypeInfo.red_type.set(i);
    localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
    localAppInfo.iNewFlag.set(1);
    paramRedTouch.a(localRedTypeInfo);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, long paramLong, int paramInt)
  {
    String str = ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).getExpContentInSimpleUI(paramQQAppInterface);
    if ((SimpleUIUtil.e()) && ("exp_shouq_dongtai_jianjie_B".equals(str)))
    {
      paramRedTouch.g();
      return;
    }
    ThreadManager.post(new LebaSpecificRedTouchBiz.1(this, paramQQAppInterface, new Handler(), paramRedTouch, paramLong), 8, null, true);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, String paramString1, String paramString2, long paramLong)
  {
    paramString2 = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    paramQQAppInterface = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramString2 != null)
    {
      paramString1 = paramString2.getAppInfoByPath(paramString1);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString1);
      }
      if (paramString1 != null)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("updateKuolieRedTouch() kuolie appInfo.buffer: ");
          paramQQAppInterface.append(paramString1.buffer.get());
          QLog.d("LebaSpecificRedTouchBiz", 2, paramQQAppInterface.toString());
        }
        Object localObject1 = paramString1.red_display_info.red_type_info.get();
        if (((List)localObject1).size() > 0)
        {
          paramQQAppInterface = null;
          paramString2 = paramString2.getBufferExtParamAppInfo(paramString1);
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("updateKuolieRedTouch() kuolie appInfo bufferExtParam: ");
            ((StringBuilder)localObject2).append(paramString2);
            QLog.d("LebaSpecificRedTouchBiz", 2, ((StringBuilder)localObject2).toString());
          }
          if (paramString2 != null) {
            paramQQAppInterface = paramString2.optString("_red_ext_uin");
          }
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            paramString2 = ((List)localObject1).iterator();
            while (paramString2.hasNext())
            {
              localObject1 = (BusinessInfoCheckUpdate.RedTypeInfo)paramString2.next();
              if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() == 3) {
                try
                {
                  localObject2 = new JSONObject(((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.get());
                  ((JSONObject)localObject2).put("uin", paramQQAppInterface);
                  ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set(((JSONObject)localObject2).toString());
                }
                catch (Throwable localThrowable)
                {
                  QLog.e("LebaSpecificRedTouchBiz", 1, "updateKuolieRedTouch()  modify image reddot red_desc JSONException ", localThrowable);
                }
              }
            }
          }
        }
      }
      if (this.b) {
        paramRedTouch.b(paramString1);
      } else {
        paramRedTouch.a(paramString1);
      }
      a(paramLong, paramRedTouch);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new LebaSpecificRedTouchBiz.2(this, paramQQAppInterface, paramRedTouch, paramString1, paramString2, paramLong));
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramString.equals("com.tx.xingqubuluo.android")) && ((paramAppRuntime instanceof QQAppInterface))) {
      a((QQAppInterface)paramAppRuntime, paramString, paramAppInfo);
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, Context paramContext, long paramLong, RedTouch paramRedTouch, String paramString, Map<Long, LebaExposureInfo> paramMap, int paramInt, boolean paramBoolean)
  {
    this.a = paramMap;
    this.b = paramBoolean;
    paramMap = String.valueOf(paramLong);
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if ((paramMap != null) && (ReadInJoyNotifyRedTouchInfo.a.equals(paramMap)))
      {
        b(paramAppRuntime, paramContext, paramRedTouch);
        a(paramLong, paramRedTouch);
        return true;
      }
      if (String.valueOf(NowLiveManager.a).equals(paramMap))
      {
        a(paramAppRuntime, paramRedTouch);
        a(paramLong, paramRedTouch);
        return true;
      }
      if (7759L == paramLong)
      {
        paramRedTouch.b();
        a(paramAppRuntime, paramContext, paramRedTouch);
        a(paramLong, paramRedTouch);
        return true;
      }
      if (7719L == paramLong)
      {
        a(paramAppRuntime, paramRedTouch, paramLong, paramInt);
        return true;
      }
      if (7720L == paramLong)
      {
        a(paramAppRuntime, paramRedTouch, paramMap, paramString, paramLong, paramInt);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz
 * JD-Core Version:    0.7.0.1
 */