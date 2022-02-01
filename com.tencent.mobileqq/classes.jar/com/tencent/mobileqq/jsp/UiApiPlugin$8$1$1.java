package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import awjf;
import bdow;
import bhin;
import bioy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.io.File;
import org.json.JSONObject;

public class UiApiPlugin$8$1$1
  implements Runnable
{
  public UiApiPlugin$8$1$1(awjf paramawjf, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_Awjf.a.a.optString("briefMsg");
    String str2 = this.jdField_a_of_type_Awjf.a.a.optString("appName");
    String str3 = this.jdField_a_of_type_Awjf.a.a.optString("iconUrl");
    String str4 = this.jdField_a_of_type_Awjf.a.a.optString("actionUrl");
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      Object localObject1 = new File(BaseApplicationImpl.getApplication().getCacheDir(), "ShareScreenShots");
      Object localObject2 = "ShareScreenShot_" + System.currentTimeMillis() + ".jpg";
      localObject1 = bhin.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject1, (String)localObject2);
      localObject2 = new Intent(this.jdField_a_of_type_Awjf.a.this$0.mRuntime.a(), ForwardRecentActivity.class);
      ((Intent)localObject2).putExtra("key_flag_from_plugin", true);
      ((Intent)localObject2).putExtra("image_url", (String)localObject1);
      ((Intent)localObject2).putExtra("forward_type", -3);
      ((Intent)localObject2).putExtra("pkg_name", "com.tencent.mobileqq");
      ((Intent)localObject2).putExtra("req_type", 5);
      ((Intent)localObject2).putExtra("k_back", true);
      ((Intent)localObject2).putExtra("brief_key", str1);
      ((Intent)localObject2).putExtra("app_name", str2);
      if (!TextUtils.isEmpty(str3)) {
        ((Intent)localObject2).putExtra("struct_share_key_source_icon", str3);
      }
      ((Intent)localObject2).putExtra("struct_share_key_source_action", "web");
      ((Intent)localObject2).putExtra("struct_share_key_source_url", str4);
      ((Intent)localObject2).putExtra("stuctmsg_bytes", bdow.a(((Intent)localObject2).getExtras()).getBytes());
      this.jdField_a_of_type_Awjf.a.this$0.startActivityForResult((Intent)localObject2, (byte)15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.8.1.1
 * JD-Core Version:    0.7.0.1
 */