import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.wtogether.util.WTogetherUtil.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class nad
{
  public static final HashMap<Long, Integer> a = new HashMap();
  
  static
  {
    a.put(Long.valueOf(204L), Integer.valueOf(203));
    a.put(Long.valueOf(1L), Integer.valueOf(1));
    a.put(Long.valueOf(3L), Integer.valueOf(3));
    a.put(Long.valueOf(101L), Integer.valueOf(101));
    a.put(Long.valueOf(102L), Integer.valueOf(102));
    a.put(Long.valueOf(103L), Integer.valueOf(103));
    a.put(Long.valueOf(201L), Integer.valueOf(201));
    a.put(Long.valueOf(202L), Integer.valueOf(202));
    a.put(Long.valueOf(203L), Integer.valueOf(203));
    a.put(Long.valueOf(204L), Integer.valueOf(204));
    a.put(Long.valueOf(107L), Integer.valueOf(107));
  }
  
  public static int a()
  {
    return (int)(ImmersiveUtils.a() * 9.0F / 16.0F);
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight(paramContext);
    }
    return i;
  }
  
  public static SuperPlayerVideoInfo a(myu parammyu)
  {
    if (parammyu == null) {
      return null;
    }
    int i = parammyu.jdField_a_of_type_Int;
    String str1 = parammyu.jdField_b_of_type_JavaLangString;
    String str2 = parammyu.jdField_c_of_type_JavaLangString;
    str2 = parammyu.d;
    int j = parammyu.a();
    String str3 = parammyu.g;
    int k;
    if (parammyu.jdField_a_of_type_Long == 0L)
    {
      parammyu = (Integer)a.get(Long.valueOf(204L));
      k = parammyu.intValue();
      if (i != 0) {
        break label109;
      }
      parammyu = SuperPlayerFactory.createVideoInfoForUrl(str1, 101, MD5Utils.toMD5(str1));
    }
    for (;;)
    {
      return parammyu;
      parammyu = (Integer)a.get(Long.valueOf(parammyu.jdField_a_of_type_Long));
      break;
      label109:
      if (i == 3) {
        parammyu = SuperPlayerFactory.createVideoInfoForTVideo(j, str2);
      } else if ((i == 2) || (i == 1)) {
        parammyu = SuperPlayerFactory.createVideoInfoForUrl(str1, k, MD5Utils.toMD5(str1));
      } else if (i == 4) {
        parammyu = SuperPlayerFactory.createVideoInfoForTVideo(j, str2, str3);
      } else {
        parammyu = null;
      }
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = VideoController.a();
    if (localObject1 != null) {}
    for (localObject1 = ((VideoController)localObject1).a();; localObject1 = null)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((lll)localObject1).a(mrr.a(paramString), false, true) == 1) {
          localObject2 = BaseApplicationImpl.getApplication().getResources().getString(2131695704);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether", 4, "getWatchTogetherInviteTip, peer[" + paramString + "], tip[" + (String)localObject2 + "]");
      }
      return localObject2;
    }
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, String paramString, mys parammys)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    atfp localatfp = new atfp();
    long l;
    boolean bool;
    if ((paramInt == 1002) || (paramInt == 1013))
    {
      l = -100001L;
      bool = false;
    }
    label64:
    int i;
    label85:
    Object localObject;
    for (;;)
    {
      if ((l == 0L) && (localatfp.jdField_c_of_type_JavaLangString == null) && (localatfp.jdField_b_of_type_JavaLangString == null))
      {
        paramInt = 1;
        if ((l != -91245L) && (l != -7010L)) {
          break label325;
        }
        i = 1;
        if (((paramInt == 0) && (i == 0)) || (parammys.jdField_c_of_type_Int >= 3) || (parammys.jdField_c_of_type_Int < 0)) {
          break label331;
        }
        parammys.jdField_b_of_type_Boolean = true;
        return;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          parammys.jdField_c_of_type_Boolean = false;
          l = -100003L;
          bool = false;
        }
        else
        {
          localObject = new cmd0x346.RspBody();
          try
          {
            ((cmd0x346.RspBody)localObject).mergeFrom(paramArrayOfByte);
            if (((cmd0x346.RspBody)localObject).msg_apply_download_rsp.has()) {
              break label217;
            }
            parammys.jdField_c_of_type_Boolean = false;
            l = -100003L;
            bool = false;
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            parammys.jdField_c_of_type_Boolean = false;
            l = -100003L;
            bool = false;
          }
          catch (Throwable paramArrayOfByte)
          {
            parammys.jdField_c_of_type_Boolean = false;
            l = -100003L;
            bool = false;
          }
          continue;
          label217:
          if (!((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.has()) {
            break label606;
          }
          if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.get() == 1) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      atfp.a(localatfp, (cmd0x346.ApplyDownloadRsp)((cmd0x346.RspBody)localObject).msg_apply_download_rsp.get(), bool, paramString);
      l = localatfp.jdField_a_of_type_Long;
      parammys.jdField_c_of_type_Boolean = true;
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether", 4, "decodeApplyDownloadRsp, retCode[" + l + "]");
      }
      break;
      bool = false;
      continue;
      paramInt = 0;
      break label64;
      label325:
      i = 0;
      break label85;
      label331:
      localObject = localatfp.d;
      String str = localatfp.jdField_b_of_type_JavaLangString;
      paramInt = localatfp.jdField_a_of_type_Short;
      paramInt = localatfp.jdField_b_of_type_Short;
      paramString = localatfp.jdField_c_of_type_JavaLangString;
      paramArrayOfByte = paramString;
      if (bool) {
        paramArrayOfByte = paramString + "&isthumb=0";
      }
      if (l == -100001L)
      {
        parammys.d = -100001;
        parammys.jdField_c_of_type_Boolean = false;
      }
      while ((str == null) || (str.length() == 0))
      {
        parammys.d = -100004;
        if (l == 0L) {
          parammys.d = -100005;
        }
        parammys.jdField_c_of_type_JavaLangString = localResources.getString(2131690943);
        parammys.jdField_c_of_type_Boolean = false;
        return;
        if ((l == -25081L) || (l == -6101L) || (l == -7003L))
        {
          parammys.jdField_c_of_type_Boolean = false;
          parammys.d = ((int)l);
          parammys.jdField_c_of_type_JavaLangString = localResources.getString(2131692655);
          return;
        }
        if (!parammys.jdField_c_of_type_Boolean)
        {
          parammys.d = -100003;
          parammys.jdField_c_of_type_JavaLangString = localResources.getString(2131690943);
          return;
        }
      }
      parammys.a = ("https://" + str + ":" + paramInt + paramArrayOfByte);
      parammys.jdField_b_of_type_JavaLangString = ((String)localObject);
      parammys.d = ((int)l);
      parammys.jdField_c_of_type_JavaLangString = null;
      parammys.jdField_c_of_type_Boolean = true;
      return;
      label606:
      bool = false;
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramActivity == null)) {
      return;
    }
    paramActivity = bhdj.a(paramActivity, 230).setTitle(null).setMessage(paramString).setNegativeButton(2131695737, new nae());
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, "", paramString3, paramString2, 25054, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString4)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WTogether", 2, "safetyReport param null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogether", 2, String.format("safetyReport [%s, %s, %s, %s, %s]", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt), paramString5 }));
    }
    ThreadManager.excute(new WTogetherUtil.2(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt), 16, null, false);
  }
  
  public static void a(Context paramContext)
  {
    if ((paramContext == null) || (!(paramContext instanceof AVActivity))) {}
    do
    {
      return;
      paramContext = ((AVActivity)paramContext).a;
    } while (paramContext == null);
    paramContext.b();
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.leftMargin = paramInt1;
    paramView.rightMargin = paramInt2;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean b()
  {
    if (QLog.isDevelopLevel())
    {
      boolean bool1 = AppNetConnInfo.isNetSupport();
      boolean bool2 = AppNetConnInfo.isWifiConn();
      QLog.i("WTogether", 4, "isNoneWifiConn, isNetSupport[" + bool1 + "], isWifiConn[" + bool2 + "]");
    }
    return (AppNetConnInfo.isNetSupport()) && (!AppNetConnInfo.isWifiConn());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nad
 * JD-Core Version:    0.7.0.1
 */