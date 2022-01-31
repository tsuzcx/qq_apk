package com.tencent.mobileqq.tribe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TribeFlowComponentInterface
  implements FlowComponentInterface
{
  public static int a = 60000;
  
  public String a()
  {
    return "tribe";
  }
  
  public void a(Activity paramActivity)
  {
    int j = -1;
    Object localObject2 = "barindex";
    String str2 = "";
    Object localObject1 = paramActivity.getIntent().getExtras();
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getString("options");
      if (QLog.isColorLevel()) {
        QLog.d("TribeFlowComponentInterface", 2, "localVideoClick option: " + (String)localObject1);
      }
    }
    for (;;)
    {
      boolean bool1;
      int i;
      String str1;
      boolean bool6;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        bool3 = ((JSONObject)localObject1).optBoolean("needTheme", false);
        str1 = str2;
      }
      catch (Exception localException1)
      {
        try
        {
          bool2 = ((JSONObject)localObject1).optBoolean("needVideoDoodle", false);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            boolean bool2 = false;
            bool1 = false;
            i = j;
            bool6 = bool3;
          }
        }
        try
        {
          bool1 = ((JSONObject)localObject1).optBoolean("needVideoWording", false);
          i = j;
        }
        catch (Exception localException3)
        {
          bool1 = false;
          i = j;
          bool6 = bool3;
          break label335;
        }
        try
        {
          localObject3 = ((JSONObject)localObject1).optString("from", "barindex");
          i = j;
          localObject2 = localObject3;
          j = ((JSONObject)localObject1).optInt("theme_id", -1);
          i = j;
          localObject2 = localObject3;
          str1 = ((JSONObject)localObject1).optString("theme_name", "");
          bool5 = bool3;
          bool4 = bool2;
          bool3 = bool1;
          localObject1 = new Intent(paramActivity, PhotoListActivity.class);
          ((Intent)localObject1).putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
          ((Intent)localObject1).putExtra("video_refer", a());
          ((Intent)localObject1).putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
          ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
          ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LocalVideoSelectActivity.class.getName());
          ((Intent)localObject1).putExtra("needTheme", bool5);
          ((Intent)localObject1).putExtra("from", (String)localObject3);
          ((Intent)localObject1).putExtra("theme_id", j);
          ((Intent)localObject1).putExtra("theme_name", str1);
          ((Intent)localObject1).putExtra("needVideoDoodle", bool4);
          ((Intent)localObject1).putExtra("needVideoWording", bool3);
          paramActivity.startActivityForResult((Intent)localObject1, 10012);
          return;
        }
        catch (Exception localException4)
        {
          bool6 = bool3;
          break label335;
        }
        localException1 = localException1;
        bool2 = false;
        bool6 = false;
        bool1 = false;
        i = j;
      }
      label335:
      j = i;
      Object localObject3 = localObject2;
      boolean bool3 = bool1;
      boolean bool4 = bool2;
      boolean bool5 = bool6;
      if (QLog.isColorLevel())
      {
        QLog.e("TribeFlowComponentInterface", 2, "onVideoCaptured: " + localException1);
        str1 = str2;
        j = i;
        localObject3 = localObject2;
        bool3 = bool1;
        bool4 = bool2;
        bool5 = bool6;
        continue;
        bool3 = false;
        bool4 = false;
        bool5 = false;
        str1 = str2;
        localObject3 = localObject2;
      }
    }
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Activity paramActivity, Intent paramIntent) {}
  
  public void c_(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.TribeFlowComponentInterface
 * JD-Core Version:    0.7.0.1
 */