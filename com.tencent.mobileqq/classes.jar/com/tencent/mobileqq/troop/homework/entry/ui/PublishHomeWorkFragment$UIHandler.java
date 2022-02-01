package com.tencent.mobileqq.troop.homework.entry.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Calendar;

public class PublishHomeWorkFragment$UIHandler
  extends Handler
{
  WeakReference<PublishHomeWorkFragment> a;
  
  PublishHomeWorkFragment$UIHandler(PublishHomeWorkFragment paramPublishHomeWorkFragment, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramPublishHomeWorkFragment);
  }
  
  void a()
  {
    PublishHomeWorkFragment localPublishHomeWorkFragment = (PublishHomeWorkFragment)this.a.get();
    if (localPublishHomeWorkFragment != null)
    {
      if ((!localPublishHomeWorkFragment.isAdded()) && (localPublishHomeWorkFragment.jdField_a_of_type_AndroidWidgetEditText == null)) {
        return;
      }
      if (localPublishHomeWorkFragment.jdField_a_of_type_JavaLangString == null) {
        localPublishHomeWorkFragment.jdField_a_of_type_JavaLangString = "";
      }
      if (localPublishHomeWorkFragment.jdField_a_of_type_Int == 1)
      {
        Object localObject = Calendar.getInstance();
        int i = ((Calendar)localObject).get(2) + 1;
        int j = ((Calendar)localObject).get(5);
        localObject = localPublishHomeWorkFragment.getString(2131697454, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localPublishHomeWorkFragment.jdField_a_of_type_JavaLangString }).trim();
        String str1 = localPublishHomeWorkFragment.getString(2131697454, new Object[] { Integer.valueOf(i), Integer.valueOf(j), "" }).trim();
        String str2 = localPublishHomeWorkFragment.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if ((TextUtils.isEmpty(str2)) || (str1.equals(str2))) {
          localPublishHomeWorkFragment.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
        }
        localPublishHomeWorkFragment.i();
        localPublishHomeWorkFragment.h();
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle msg ");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("PublishHomeWorkFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (PublishHomeWorkFragment)this.a.get();
    if ((localObject != null) && (((PublishHomeWorkFragment)localObject).isAdded()))
    {
      int i = paramMessage.what;
      if (i != 3)
      {
        if (i != 101)
        {
          if (i != 102)
          {
            switch (i)
            {
            default: 
              return;
            case 515: 
              QLog.d("PublishHomeWorkFragment", 1, "init data time out");
              ((PublishHomeWorkFragment)localObject).j = true;
              a();
              return;
            case 514: 
              ((PublishHomeWorkFragment)localObject).h();
              return;
            }
            a();
            return;
          }
          i = (int)((PublishHomeWorkFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
          if (i < 1000)
          {
            QQToast.a(((PublishHomeWorkFragment)localObject).getActivity(), HardCodeUtil.a(2131708825), 0).a();
            ((PublishHomeWorkFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
            return;
          }
          if (!NetworkUtil.isNetSupport(((PublishHomeWorkFragment)localObject).getActivity()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublishHomeWorkFragment", 2, "no network toast");
            }
            QQToast.a(((PublishHomeWorkFragment)localObject).getActivity(), 2131697226, 0).a();
            ((PublishHomeWorkFragment)localObject).g = false;
            ((PublishHomeWorkFragment)localObject).n();
            return;
          }
          paramMessage = paramMessage.obj.toString();
          File localFile = new File(paramMessage);
          long l;
          if (localFile.exists()) {
            l = localFile.length();
          } else {
            l = 0L;
          }
          paramMessage = new AudioInfo(paramMessage, null, i / 1000, (int)l, ((PublishHomeWorkFragment)localObject).b);
          ((PublishHomeWorkFragment)localObject).jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramMessage);
          ((PublishHomeWorkFragment)localObject).g = false;
          ((PublishHomeWorkFragment)localObject).n();
          return;
        }
        ((PublishHomeWorkFragment)localObject).g = false;
        ((PublishHomeWorkFragment)localObject).n();
        return;
      }
      ((PublishHomeWorkFragment)localObject).g = true;
      ((PublishHomeWorkFragment)localObject).jdField_a_of_type_ComTencentWidgetActionSheet.setOutsideDismissEnableCompat(false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "reference null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.UIHandler
 * JD-Core Version:    0.7.0.1
 */