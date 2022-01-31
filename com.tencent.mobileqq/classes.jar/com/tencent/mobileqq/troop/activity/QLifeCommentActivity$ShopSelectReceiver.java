package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

public class QLifeCommentActivity$ShopSelectReceiver
  extends BroadcastReceiver
{
  protected QLifeCommentActivity$ShopSelectReceiver(QLifeCommentActivity paramQLifeCommentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("qlifeShopSelect"))) {
        break label43;
      }
    }
    label43:
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QLifeCommentActivity", 2, "onReceive:" + paramContext);
        }
        try
        {
          paramContext = new JSONObject(paramContext);
          paramIntent = paramContext.optString("selectTitle");
          String str1 = paramContext.optString("selectContent");
          String str2 = paramContext.optString("shopID");
          if (!TextUtils.isEmpty(paramIntent)) {
            this.a.e.setText(paramIntent);
          }
          if (!TextUtils.isEmpty(str1)) {
            this.a.jdField_f_of_type_AndroidWidgetTextView.setText(str1);
          }
          if (!TextUtils.isEmpty(str2))
          {
            this.a.v = str2;
            this.a.x = paramContext.optString("sp");
            this.a.y = paramContext.optString("idType");
            this.a.z = paramContext.optString("source");
            if (this.a.a != null) {
              this.a.a.a = true;
            }
            TroopBarUtils.a.clear();
            this.a.jdField_f_of_type_JavaLangString = ("http://s.p.qq.com/cgi-bin/coupon_q/social/binary_upload.fcg?&sp=" + this.a.x + "&shopid=" + this.a.v);
            return;
          }
        }
        catch (JSONException paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QLifeCommentActivity", 2, "onReceive JSONException : " + paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.QLifeCommentActivity.ShopSelectReceiver
 * JD-Core Version:    0.7.0.1
 */