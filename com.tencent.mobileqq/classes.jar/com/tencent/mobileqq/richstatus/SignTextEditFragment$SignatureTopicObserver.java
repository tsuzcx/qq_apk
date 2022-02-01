package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import com.tencent.mobileqq.adapter.TopicListAdapter;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

class SignTextEditFragment$SignatureTopicObserver
  extends SignatureObserver
{
  private SignTextEditFragment$SignatureTopicObserver(SignTextEditFragment paramSignTextEditFragment) {}
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null)
    {
      SignTextEditFragment.a(this.a, 2);
      return;
    }
    paramObject = (Bundle)paramObject;
    int i = paramObject.getInt("param_searchResult", 0);
    paramObject = (ArrayList)paramObject.getSerializable("param_topicInfoList");
    if ((paramObject != null) && (paramObject.size() > 0)) {
      SignTextEditFragment.a(this.a, 4);
    } else if (i == 0) {
      SignTextEditFragment.a(this.a, 3);
    } else {
      SignTextEditFragment.a(this.a, 2);
    }
    if (this.a.n.a(paramObject, true)) {
      this.a.n.notifyDataSetChanged();
    }
  }
  
  protected void f(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null)
    {
      SignTextEditFragment.a(this.a, 2);
      return;
    }
    Object localObject = (Bundle)paramObject;
    int j = ((Bundle)localObject).getInt("param_atIndex");
    int k = ((Bundle)localObject).getInt("param_atKeyLen");
    paramObject = ((Bundle)localObject).getString("param_atKey");
    long l = ((Bundle)localObject).getLong("param_reqTs");
    localObject = (ArrayList)((Bundle)localObject).getSerializable("param_topicInfoList");
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onGetTopicWithKey[%b,%d] key=[%s] [atIndex=%d, keyLen=%d],reqTs=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), paramObject, Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l) }));
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      SignTextEditFragment.a(this.a, 4);
    } else {
      SignTextEditFragment.a(this.a, 3);
    }
    if (this.a.n.a((List)localObject, false)) {
      this.a.n.notifyDataSetChanged();
    }
    this.a.f.setTag(new Object[] { Integer.valueOf(j), Integer.valueOf(k), paramObject, Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.SignatureTopicObserver
 * JD-Core Version:    0.7.0.1
 */