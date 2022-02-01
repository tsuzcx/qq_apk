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
    if (paramSubmitHomeWorkFragment.F != null)
    {
      if (paramSubmitHomeWorkFragment.d == null) {
        return;
      }
      if (paramSubmitHomeWorkFragment.F.isEmpty())
      {
        paramSubmitHomeWorkFragment.d.setVisibility(8);
        paramSubmitHomeWorkFragment.e.a();
        paramSubmitHomeWorkFragment.e.setHint(paramSubmitHomeWorkFragment.getActivity().getString(2131895263));
        paramSubmitHomeWorkFragment.e.getAdapter().notifyDataSetChanged();
        return;
      }
      if (!paramSubmitHomeWorkFragment.z)
      {
        paramSubmitHomeWorkFragment.d.c();
        Iterator localIterator = paramSubmitHomeWorkFragment.F.iterator();
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
          paramSubmitHomeWorkFragment.d.a(EditItemInfoFactory.a(localJSONObject));
        }
        paramSubmitHomeWorkFragment.z = true;
        if (paramSubmitHomeWorkFragment.D == null) {
          paramSubmitHomeWorkFragment.D = paramSubmitHomeWorkFragment.d.getData();
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
            i = (int)localSubmitHomeWorkFragment.x.getRecordTime();
            if (i < 1000)
            {
              QQToast.makeText(localSubmitHomeWorkFragment.getActivity(), HardCodeUtil.a(2131911941), 0).show();
              localSubmitHomeWorkFragment.x.e();
              return;
            }
            if (!NetworkUtil.isNetSupport(localSubmitHomeWorkFragment.getActivity()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SubmitHomeWorkFragment", 2, "no network toast");
              }
              QQToast.makeText(localSubmitHomeWorkFragment.getActivity(), 2131894999, 0).show();
              localSubmitHomeWorkFragment.y = false;
              localSubmitHomeWorkFragment.r();
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
            paramMessage = new AudioInfo(paramMessage, null, i / 1000, (int)l, localSubmitHomeWorkFragment.H);
            localSubmitHomeWorkFragment.e.a(paramMessage);
            localSubmitHomeWorkFragment.y = false;
            localSubmitHomeWorkFragment.r();
            return;
          }
          localSubmitHomeWorkFragment.y = false;
          localSubmitHomeWorkFragment.r();
          return;
        }
        a(localSubmitHomeWorkFragment);
        return;
      }
      localSubmitHomeWorkFragment.y = true;
      localSubmitHomeWorkFragment.w.setOutsideDismissEnableCompat(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.UIHandler
 * JD-Core Version:    0.7.0.1
 */