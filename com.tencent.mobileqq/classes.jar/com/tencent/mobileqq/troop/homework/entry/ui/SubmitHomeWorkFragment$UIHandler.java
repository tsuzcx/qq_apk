package com.tencent.mobileqq.troop.homework.entry.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView.Adapter;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class SubmitHomeWorkFragment$UIHandler
  extends Handler
{
  WeakReference<SubmitHomeWorkFragment> a;
  
  SubmitHomeWorkFragment$UIHandler(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramSubmitHomeWorkFragment);
  }
  
  void a(SubmitHomeWorkFragment paramSubmitHomeWorkFragment)
  {
    if (paramSubmitHomeWorkFragment.jdField_a_of_type_JavaUtilLinkedList != null)
    {
      if (paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor == null) {
        return;
      }
      if (paramSubmitHomeWorkFragment.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setVisibility(8);
        paramSubmitHomeWorkFragment.b.a();
        paramSubmitHomeWorkFragment.b.setHint(paramSubmitHomeWorkFragment.getActivity().getString(2131697490));
        paramSubmitHomeWorkFragment.b.getAdapter().notifyDataSetChanged();
        return;
      }
      if (!paramSubmitHomeWorkFragment.jdField_c_of_type_Boolean)
      {
        paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.c();
        Iterator localIterator = paramSubmitHomeWorkFragment.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          JSONObject localJSONObject = (JSONObject)localIterator.next();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("insert special item: ");
            localStringBuilder.append(localJSONObject.optString("type"));
            QLog.d("SubmitHomeWorkFragment", 2, localStringBuilder.toString());
          }
          paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(EditItemInfoFactory.a(localJSONObject));
        }
        paramSubmitHomeWorkFragment.jdField_c_of_type_Boolean = true;
        if (paramSubmitHomeWorkFragment.jdField_c_of_type_JavaLangString == null) {
          paramSubmitHomeWorkFragment.jdField_c_of_type_JavaLangString = paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
        }
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    SubmitHomeWorkFragment localSubmitHomeWorkFragment = (SubmitHomeWorkFragment)this.a.get();
    if (localSubmitHomeWorkFragment != null)
    {
      if (!localSubmitHomeWorkFragment.isAdded()) {
        return;
      }
      int i = paramMessage.what;
      if (i != 3)
      {
        if (i != 513)
        {
          if (i != 101)
          {
            if (i != 102) {
              return;
            }
            i = (int)localSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
            if (i < 1000)
            {
              QQToast.a(localSubmitHomeWorkFragment.getActivity(), HardCodeUtil.a(2131714431), 0).a();
              localSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
              return;
            }
            if (!NetworkUtil.isNetSupport(localSubmitHomeWorkFragment.getActivity()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SubmitHomeWorkFragment", 2, "no network toast");
              }
              QQToast.a(localSubmitHomeWorkFragment.getActivity(), 2131697226, 0).a();
              localSubmitHomeWorkFragment.jdField_a_of_type_Boolean = false;
              localSubmitHomeWorkFragment.k();
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
            paramMessage = new AudioInfo(paramMessage, null, i / 1000, (int)l, localSubmitHomeWorkFragment.d);
            localSubmitHomeWorkFragment.b.a(paramMessage);
            localSubmitHomeWorkFragment.jdField_a_of_type_Boolean = false;
            localSubmitHomeWorkFragment.k();
            return;
          }
          localSubmitHomeWorkFragment.jdField_a_of_type_Boolean = false;
          localSubmitHomeWorkFragment.k();
          return;
        }
        a(localSubmitHomeWorkFragment);
        return;
      }
      localSubmitHomeWorkFragment.jdField_a_of_type_Boolean = true;
      localSubmitHomeWorkFragment.jdField_a_of_type_ComTencentWidgetActionSheet.setOutsideDismissEnableCompat(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.UIHandler
 * JD-Core Version:    0.7.0.1
 */