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
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.leba.business.ILebaRedTouchBiz;
import com.tencent.mobileqq.leba.entity.LebaExposureInfo;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
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
  public static int a;
  protected boolean a;
  private int b;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public LebaSpecificRedTouchBiz()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (!paramString.equals("com.tx.xingqubuluo.android"))) {
      return;
    }
    if (!TextUtils.isEmpty(paramAppInfo.icon_url.get())) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_tribe", "", "dynamic", "exp_tribe", 0, 0, i + "", "", "", "");
      return;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext, RedTouch paramRedTouch)
  {
    Object localObject;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    if (paramQQAppInterface != null)
    {
      localObject = (ReadInJoyManager)paramQQAppInterface.getManager(QQManagerFactory.READINJOY_MANAGER);
      if (localObject != null)
      {
        localRedTypeInfo = ((ReadInJoyManager)localObject).a();
        paramQQAppInterface = ((ReadInJoyManager)localObject).a();
        localObject = ((ReadInJoyManager)localObject).a();
      }
    }
    int i;
    switch (((ReadInJoyNotifyRedTouchInfo)localObject).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      i = ((ReadInJoyNotifyRedTouchInfo)localObject).jdField_b_of_type_Int;
      if (i > 99) {
        localRedTypeInfo.red_content.set("99+");
      }
      for (;;)
      {
        localRedTypeInfo.red_type.set(5);
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
        paramQQAppInterface.iNewFlag.set(1);
        paramRedTouch.a(paramQQAppInterface);
        return;
        localRedTypeInfo.red_content.set(i + "");
      }
    case 3: 
      localRedTypeInfo.red_type.set(3);
      i = ((ReadInJoyNotifyRedTouchInfo)localObject).jdField_c_of_type_Int;
      localRedTypeInfo.red_desc.set("{'drawable':" + i + "}");
      paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
      paramQQAppInterface.iNewFlag.set(1);
      paramRedTouch.a(paramQQAppInterface);
      return;
    case 2: 
      localObject = ((ReadInJoyNotifyRedTouchInfo)localObject).jdField_b_of_type_JavaLangString;
      localRedTypeInfo.red_content.set((String)localObject + "");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#777777'}");
      paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(9);
      localRedTypeInfo.red_content.set(DisplayUtil.a(paramContext, 3.0F) + "");
      localRedTypeInfo.red_desc.set("");
      paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
      paramContext = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramContext.red_type.set(0);
      paramQQAppInterface.red_display_info.red_type_info.add(paramContext);
      paramQQAppInterface.iNewFlag.set(1);
      paramRedTouch.a(paramQQAppInterface);
      return;
    case 4: 
      paramContext = ((ReadInJoyNotifyRedTouchInfo)localObject).jdField_b_of_type_JavaLangString;
      localRedTypeInfo.red_content.set(paramContext + "");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#FF0000'}");
      paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
      paramQQAppInterface.iNewFlag.set(1);
      paramRedTouch.a(paramQQAppInterface);
      return;
    }
    paramRedTouch.d();
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, RedTouch paramRedTouch)
  {
    if (paramQQAppInterface != null)
    {
      if (!ConfessConfig.a(paramQQAppInterface, "redpoint_leba_show")) {
        break label311;
      }
      paramContext = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
      if (paramContext == null) {
        break label225;
      }
    }
    for (paramQQAppInterface = paramContext.a(paramQQAppInterface); (!TextUtils.isEmpty(paramQQAppInterface)) && (!this.jdField_a_of_type_Boolean); paramQQAppInterface = "")
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
        paramQQAppInterface.setMaxWidth(ViewUtils.a(200.0F));
        paramContext.weight = 1.0F;
        paramContext.width = 0;
        paramContext.rightMargin = ViewUtils.a(4.0F);
        paramQQAppInterface.setEllipsize(TextUtils.TruncateAt.END);
        paramQQAppInterface.setLayoutParams(paramContext);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        label225:
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
    label311:
    paramRedTouch.d();
  }
  
  protected void a(QQAppInterface paramQQAppInterface, NearbyRedInfo paramNearbyRedInfo, RedTouch paramRedTouch)
  {
    int j = 1;
    if (paramRedTouch == null) {}
    Object localObject;
    do
    {
      return;
      jdField_a_of_type_Int = paramNearbyRedInfo.d;
      this.jdField_b_of_type_Int = paramNearbyRedInfo.jdField_c_of_type_Int;
      switch (paramNearbyRedInfo.jdField_a_of_type_Int)
      {
      default: 
        paramRedTouch.a(null);
        return;
      case 11: 
        if (!this.jdField_a_of_type_Boolean)
        {
          paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramQQAppInterface.red_type.set(0);
          paramQQAppInterface.red_content.set("");
          paramQQAppInterface.red_desc.set("");
          paramRedTouch.a(paramQQAppInterface);
          return;
        }
        paramQQAppInterface = new BusinessInfoCheckUpdate.AppInfo();
        paramQQAppInterface.iNewFlag.set(1);
        paramQQAppInterface.exposure_max.set(1);
        localObject = new BusinessInfoCheckUpdate.RedDisplayInfo();
      }
    } while ((TextUtils.isEmpty(paramNearbyRedInfo.jdField_b_of_type_JavaLangString)) && (TextUtils.isEmpty(paramNearbyRedInfo.jdField_c_of_type_JavaLangString)));
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    if (!TextUtils.isEmpty(paramNearbyRedInfo.jdField_b_of_type_JavaLangString))
    {
      localRedTypeInfo.red_type.set(11);
      localRedTypeInfo.red_content.set(paramNearbyRedInfo.jdField_b_of_type_JavaLangString);
      ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(localRedTypeInfo);
    }
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramNearbyRedInfo.jdField_c_of_type_JavaLangString))
      {
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(-100);
        localRedTypeInfo.red_content.set(paramNearbyRedInfo.jdField_c_of_type_JavaLangString);
        ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(localRedTypeInfo);
      }
      for (;;)
      {
        if ((i == 0) && (j != 0))
        {
          paramNearbyRedInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramNearbyRedInfo.red_type.set(0);
          ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(paramNearbyRedInfo);
        }
        paramQQAppInterface.red_display_info.set((MessageMicro)localObject);
        paramRedTouch.b(paramQQAppInterface);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramQQAppInterface.red_type.set(0);
          paramQQAppInterface.red_content.set("");
          paramQQAppInterface.red_desc.set("");
          paramRedTouch.a(paramQQAppInterface);
          return;
        }
        paramQQAppInterface = (String)paramNearbyRedInfo.jdField_a_of_type_JavaUtilList.get(0);
        paramNearbyRedInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramNearbyRedInfo.red_type.set(3);
        paramNearbyRedInfo.red_content.set(paramQQAppInterface);
        paramNearbyRedInfo.red_desc.set("{'av':1, 'dot':1}");
        paramRedTouch.a(paramNearbyRedInfo);
        return;
        localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(5);
        paramQQAppInterface = paramNearbyRedInfo.jdField_b_of_type_Int + "";
        if (paramNearbyRedInfo.jdField_b_of_type_Int > 99) {
          paramQQAppInterface = "99+";
        }
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set(paramQQAppInterface);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("{'cn':'#FF0000'}");
        paramRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
        return;
        paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramQQAppInterface.red_type.set(0);
        paramQQAppInterface.red_content.set("");
        paramQQAppInterface.red_desc.set("");
        paramRedTouch.a(paramQQAppInterface);
        return;
        j = 0;
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return;
    }
    paramQQAppInterface = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    oidb_0x791.RedDotInfo localRedDotInfo = paramQQAppInterface.a();
    if (localRedDotInfo == null)
    {
      paramRedTouch.d();
      return;
    }
    StoryReportor.a("dynamic", "exp_story", 0, paramQQAppInterface.b(), new String[0]);
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    int i;
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      i = -1;
    case 11: 
    case 37: 
    case 8: 
    case 35: 
      label126:
      while (i != -1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("storyRedDotDebug", 2, "更新动态红点:" + TroopRedTouchManager.a(localRedDotInfo));
        }
        localRedTypeInfo.red_type.set(i);
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        paramRedTouch.a(localRedTypeInfo);
        return;
        localRedTypeInfo.red_content.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8() + "");
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        i = 4;
        continue;
        paramQQAppInterface = "New";
        try
        {
          String str = new JSONObject(localRedDotInfo.str_custom_buffer.get().toStringUtf8()).getString("red_word");
          paramQQAppInterface = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            SLog.d("LebaSpecificRedTouchBiz", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
          }
        }
        localRedTypeInfo.red_content.set(paramQQAppInterface);
        localRedTypeInfo.red_desc.set("{'cn':'#00000000' ,'cr':'#777777'}");
        i = 4;
        continue;
        i = 0;
        continue;
        paramQQAppInterface = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label436;
        }
        try
        {
          long l = new JSONObject(paramQQAppInterface).optLong("image_red_display_780", 1L);
          SLog.e("LebaSpecificRedTouchBiz", "updateStoryRedTouch() APPID_STORY_IMG: red display=%d", new Object[] { Long.valueOf(l) });
          if (l != 0L) {
            break label445;
          }
          paramRedTouch.d();
          i = -1;
        }
        catch (JSONException paramQQAppInterface)
        {
          SLog.c("LebaSpecificRedTouchBiz", "updateStoryRedTouch() APPID_STORY_IMG: Error parse json: ", paramQQAppInterface);
          i = -1;
        }
      }
      label436:
      SLog.b("LebaSpecificRedTouchBiz", "updateStoryRedTouch() APPID_STORY_IMG: str_custom_buffer is null");
      label445:
      i = localRedDotInfo.uint32_cmd_uin_type.get();
      if (i == 0)
      {
        localObject = localRedDotInfo.str_face_url.get().toStringUtf8();
        paramQQAppInterface = String.format("{'uin':'%s','dot':1, 'av':1}", new Object[] { localRedDotInfo.uint64_cmd_uin.get() + "" });
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramQQAppInterface = "{'av':1, 'dot':1}";
          localRedTypeInfo.red_content.set((String)localObject);
        }
        localRedTypeInfo.red_desc.set(paramQQAppInterface);
      }
      for (;;)
      {
        i = 3;
        break label126;
        if (i != 1) {
          break;
        }
        paramQQAppInterface = "https://p.qlogo.cn/gh/" + localRedDotInfo.uint64_cmd_uin.get() + "/" + localRedDotInfo.uint64_cmd_uin.get() + "/100?t=" + TroopRedTouchManager.d;
        localRedTypeInfo.red_content.set(paramQQAppInterface);
        localRedTypeInfo.red_desc.set("{'av':1, 'dot':1}");
      }
    }
    Object localObject = localRedTypeInfo.red_content;
    if (localRedDotInfo.uint32_number.get() > 99) {}
    for (paramQQAppInterface = "99+";; paramQQAppInterface = localRedDotInfo.uint32_number.get() + "")
    {
      ((PBStringField)localObject).set(paramQQAppInterface);
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      i = 4;
      break;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, long paramLong, int paramInt)
  {
    ThreadManager.post(new LebaSpecificRedTouchBiz.1(this, paramQQAppInterface, new Handler(), paramRedTouch, paramLong), 8, null, true);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, String paramString1, String paramString2, long paramLong)
  {
    paramString2 = (RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramString2 != null)
    {
      paramString1 = paramString2.a(paramString1);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString1);
      }
      if (paramString1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaSpecificRedTouchBiz", 2, "updateKuolieRedTouch() kuolie appInfo.buffer: " + paramString1.buffer.get());
        }
        Object localObject = paramString1.red_display_info.red_type_info.get();
        if (((List)localObject).size() > 0)
        {
          paramQQAppInterface = null;
          paramString2 = paramString2.a(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("LebaSpecificRedTouchBiz", 2, "updateKuolieRedTouch() kuolie appInfo bufferExtParam: " + paramString2);
          }
          if (paramString2 != null) {
            paramQQAppInterface = paramString2.optString("_red_ext_uin");
          }
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            paramString2 = ((List)localObject).iterator();
            while (paramString2.hasNext())
            {
              localObject = (BusinessInfoCheckUpdate.RedTypeInfo)paramString2.next();
              if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 3) {
                try
                {
                  JSONObject localJSONObject = new JSONObject(((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.get());
                  localJSONObject.put("uin", paramQQAppInterface);
                  ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set(localJSONObject.toString());
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
      if (!this.jdField_a_of_type_Boolean) {
        break label297;
      }
      paramRedTouch.b(paramString1);
    }
    for (;;)
    {
      a(paramLong, paramRedTouch);
      return;
      label297:
      paramRedTouch.a(paramString1);
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
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_Boolean = paramBoolean;
    boolean bool = false;
    paramMap = String.valueOf(paramLong);
    paramBoolean = bool;
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if ((paramMap == null) || (!ReadInJoyNotifyRedTouchInfo.jdField_a_of_type_JavaLangString.equals(paramMap))) {
        break label74;
      }
      b(paramAppRuntime, paramContext, paramRedTouch);
      a(paramLong, paramRedTouch);
      paramBoolean = true;
    }
    label74:
    do
    {
      return paramBoolean;
      if (String.valueOf(NowLiveManager.jdField_a_of_type_Int).equals(paramMap))
      {
        a(paramAppRuntime, paramRedTouch);
        a(paramLong, paramRedTouch);
        return true;
      }
      if (7759L == paramLong)
      {
        paramRedTouch.a();
        a(paramAppRuntime, paramContext, paramRedTouch);
        a(paramLong, paramRedTouch);
        return true;
      }
      if (7719L == paramLong)
      {
        a(paramAppRuntime, paramRedTouch, paramLong, paramInt);
        return true;
      }
      paramBoolean = bool;
    } while (7720L != paramLong);
    a(paramAppRuntime, paramRedTouch, paramMap, paramString, paramLong, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz
 * JD-Core Version:    0.7.0.1
 */