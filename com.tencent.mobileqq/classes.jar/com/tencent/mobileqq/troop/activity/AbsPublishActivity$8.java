package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AbsPublishActivity$8
  extends Handler
{
  AbsPublishActivity$8(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    switch (paramMessage.what)
                    {
                    default: 
                      return;
                    }
                  } while (this.a.a(1));
                  if (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 9) {
                    break;
                  }
                  QQToast.a(this.a, "最多只能选择9张图片", 0).b(this.a.getTitleBarHeight());
                  return;
                  this.a.c(false);
                  this.a.rightViewText.setEnabled(true);
                  this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
                  this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
                  QQToast.a(this.a, 2131696229, 1).b(this.a.getTitleBarHeight());
                } while (!(paramMessage.obj instanceof String));
                paramMessage = (String)paramMessage.obj;
                this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramMessage);
                return;
                this.a.c(false);
                this.a.i();
                return;
                if ((paramMessage.arg1 == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null)) {
                  this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.url = ((String)paramMessage.obj);
                }
              } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
              this.a.i();
              return;
              this.a.c(false);
              if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
              }
              this.a.rightViewText.setEnabled(true);
              this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
              this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
              QQToast.a(this.a, 2131696229, 1).b(this.a.getTitleBarHeight());
              return;
            } while (this.a.a(2));
            if ((Build.VERSION.SDK_INT >= 23) && (this.a.checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
            {
              this.a.requestPermissions(new AbsPublishActivity.8.1(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
              return;
            }
            paramMessage = new Intent();
            paramMessage.putExtra("audio_max_length", this.a.h);
            if (this.a.q != null)
            {
              paramMessage.putExtra("from", "publish");
              paramMessage.putExtra("bid", this.a.q);
              paramMessage.putExtra("fromflag", this.a.jdField_b_of_type_JavaLangString);
              TroopBarUtils.a(this.a.o, this.a.p, "Clk_record", this.a.q, this.a.jdField_b_of_type_JavaLangString, "", "");
            }
            PublicFragmentActivity.Launcher.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramMessage, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
            return;
          } while (!this.a.a(4));
          return;
          this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
          return;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown()))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(5, 0);
            this.a.f();
            this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new AbsPublishActivity.8.2(this), 200L);
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(5, 1);
          this.a.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130843808);
          this.a.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(this.a.getString(2131696227));
          this.a.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          InputMethodUtil.b(this.a.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new AbsPublishActivity.8.3(this), 200L);
        } while (!(this.a.getActivity() instanceof TroopBarPublishActivity));
        localObject = (TroopBarPublishActivity)this.a.getActivity();
        paramMessage = new StringBuilder();
      } while (((TroopBarPublishActivity)localObject).a == null);
      Object localObject = ((TroopBarPublishActivity)localObject).a.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramMessage.append(((TroopBarMyBar)((Iterator)localObject).next()).c).append("|");
      }
    } while (!this.a.a(8));
    return;
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList);
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() < 9) {
        bool = true;
      }
      paramMessage.a(bool, true);
      this.a.a(1);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setCurType(1);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
      return;
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(false, true);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    this.a.a(0);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setCurType(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishActivity.8
 * JD-Core Version:    0.7.0.1
 */