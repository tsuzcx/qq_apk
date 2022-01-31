package com.tencent.mobileqq.portal;

import agrn;
import agrp;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneShareManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ShareHelper
  implements AdapterView.OnItemClickListener
{
  int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  public WeakReference a;
  int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private int g;
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Bitmap localBitmap = null; localBitmap == null; localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      ThreadManager.post(new agrn(this, paramString4, paramInt, paramString1, paramString2, paramString3), 5, null, false);
      return;
    }
    a(paramInt, paramString1, paramString2, paramString3, paramString4, localBitmap);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(paramInt).append(" , ");
      if (paramBitmap != null)
      {
        bool = true;
        QLog.i("ShareHelper", 2, bool);
      }
    }
    else
    {
      if (paramInt != 2) {
        break label175;
      }
      localObject = new Bundle();
      paramBitmap = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramBitmap = paramString3;
      }
      ((Bundle)localObject).putString("title", paramBitmap);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString3;
      }
      ((Bundle)localObject).putString("desc", paramString1);
      ((Bundle)localObject).putString("detail_url", paramString3);
      paramString1 = new ArrayList(1);
      paramString1.add(paramString4);
      ((Bundle)localObject).putStringArrayList("image_url", paramString1);
      ((Bundle)localObject).putLong("req_share_id", 0L);
      QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (Bundle)localObject, null);
    }
    label175:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
        bool = false;
        break;
        if (paramInt != 1) {
          break label394;
        }
        paramBitmap = new Intent();
        paramBitmap.setClass(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        paramBitmap.putExtra("isFromShare", true);
        paramBitmap.putExtra("key_flag_from_plugin", true);
        paramBitmap.putExtra("forward_type", 1001);
        paramBitmap.putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
        paramBitmap.putExtra("app_name", "QQ团队");
        paramBitmap.putExtra("detail_url", paramString3);
        paramBitmap.putExtra("title", paramString1);
        paramBitmap.putExtra("desc", paramString2);
        paramBitmap.putExtra("image_url_remote", paramString4);
        paramBitmap.putExtra("req_type", 1);
        paramBitmap.putExtra("pluginName", "web_share");
        paramBitmap.putExtra("brief_key", this.jdField_a_of_type_AndroidAppActivity.getString(2131430119, new Object[] { paramString1 }));
        paramBitmap.putExtra("struct_share_key_content_action", "web");
        paramBitmap.putExtra("pubUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramString1 = StructMsgFactory.a(paramBitmap.getExtras());
        if (paramString1 != null)
        {
          paramBitmap.putExtra("stuctmsg_bytes", paramString1.getBytes());
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBitmap);
        }
      }
    } while ((paramInt != 3) && (paramInt != 4));
    label394:
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131435335;
    }
    for (;;)
    {
      if (i != -1)
      {
        QRUtils.a(0, i);
        break;
        if (WXShareHelper.a().b()) {
          break label524;
        }
        i = 2131435336;
        continue;
      }
      paramString4 = String.valueOf(System.currentTimeMillis());
      localObject = new agrp(this, paramString4);
      WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
      if (paramInt == 3)
      {
        WXShareHelper.a().b(paramString4, paramString1, paramBitmap, paramString2, paramString3, 0);
        break;
      }
      if (paramInt != 4) {
        break;
      }
      WXShareHelper.a().b(paramString4, paramString2, paramBitmap, "", paramString3, 1);
      break;
      label524:
      i = -1;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    do
    {
      do
      {
        return;
        switch (((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.jdField_b_of_type_Int)
        {
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          paramInt = -1;
          if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          }
          break;
        }
      } while (paramInt == -1);
      if (this.g == 2) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80079D5", "0X80079D5", 0, 0, String.valueOf(paramInt), "", "", "");
      }
      for (;;)
      {
        if (this.jdField_c_of_type_Int == 1)
        {
          RedPacketServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_Int, 1, paramInt, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0);
          return;
          paramView = this.jdField_b_of_type_JavaLangString;
          String str1 = this.jdField_d_of_type_JavaLangString;
          String str2 = this.jdField_a_of_type_JavaLangString;
          if (this.jdField_c_of_type_Int == 1) {}
          for (paramAdapterView = this.jdField_e_of_type_JavaLangString;; paramAdapterView = this.jdField_f_of_type_JavaLangString)
          {
            a(1, paramView, str1, str2, paramAdapterView, null);
            paramInt = 1;
            break;
          }
          paramView = this.jdField_b_of_type_JavaLangString;
          str1 = this.jdField_d_of_type_JavaLangString;
          str2 = this.jdField_a_of_type_JavaLangString;
          if (this.jdField_c_of_type_Int == 1) {}
          for (paramAdapterView = this.jdField_e_of_type_JavaLangString;; paramAdapterView = this.jdField_f_of_type_JavaLangString)
          {
            a(2, paramView, str1, str2, paramAdapterView, null);
            paramInt = 2;
            break;
          }
          paramView = this.jdField_b_of_type_JavaLangString;
          str1 = this.jdField_d_of_type_JavaLangString;
          str2 = this.jdField_a_of_type_JavaLangString;
          if (this.jdField_c_of_type_Int == 1) {}
          for (paramAdapterView = this.jdField_e_of_type_JavaLangString;; paramAdapterView = this.jdField_f_of_type_JavaLangString)
          {
            a(3, paramView, str1, str2, paramAdapterView);
            paramInt = 3;
            break;
          }
          paramView = this.jdField_b_of_type_JavaLangString;
          str1 = this.jdField_c_of_type_JavaLangString;
          str2 = this.jdField_a_of_type_JavaLangString;
          if (this.jdField_c_of_type_Int == 1) {}
          for (paramAdapterView = this.jdField_e_of_type_JavaLangString;; paramAdapterView = this.jdField_f_of_type_JavaLangString)
          {
            a(4, paramView, str1, str2, paramAdapterView);
            paramInt = 4;
            break;
          }
          if (this.g == 1)
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (this.jdField_c_of_type_Int == 1) {}
            for (paramAdapterView = "1";; paramAdapterView = "2")
            {
              ReportController.b(paramView, "dc01440", "", "", "0X80077F5", "0X80077F5", 0, 0, String.valueOf(paramInt), paramAdapterView, String.valueOf(this.jdField_f_of_type_Int), "");
              break;
            }
          }
        }
      }
    } while (this.jdField_c_of_type_Int != 2);
    RedPacketServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_Int, 2, paramInt, 0, 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ShareHelper
 * JD-Core Version:    0.7.0.1
 */