package com.tencent.mobileqq.writetogetherui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.writetogether.WriteTogetherOidbObserver;
import com.tencent.mobileqq.writetogether.data.CreateDocParam;
import com.tencent.mobileqq.writetogether.data.OpenDocParam;

class WriteTogetherEditorFragment$3
  extends WriteTogetherOidbObserver
{
  WriteTogetherEditorFragment$3(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void a(int paramInt, boolean paramBoolean, CreateDocParam paramCreateDocParam)
  {
    super.a(paramInt, paramBoolean, paramCreateDocParam);
    WriteTogetherEditorFragment.a(this.a, paramBoolean, paramCreateDocParam);
  }
  
  public void a(int paramInt, boolean paramBoolean, OpenDocParam paramOpenDocParam)
  {
    super.a(paramInt, paramBoolean, paramOpenDocParam);
    WriteTogetherEditorFragment.a(this.a, paramBoolean, paramOpenDocParam);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    super.a(paramInt, paramBoolean, paramArrayOfObject);
    WriteTogetherEditorFragment.a(this.a, false);
    WriteTogetherEditorFragment.b(this.a, paramBoolean);
    WriteTogetherEditorFragment.a(this.a);
    if (!paramBoolean) {
      QQToast.a(WriteTogetherEditorFragment.a(this.a), WriteTogetherEditorFragment.a(this.a).getResources().getString(2131720474), 0).a();
    }
    if (paramBoolean)
    {
      paramArrayOfObject = WriteTogetherEditorFragment.a(this.a, paramArrayOfObject);
      this.a.getQBaseActivity().setResult(15, paramArrayOfObject);
      this.a.getQBaseActivity().finish();
      WriteTogetherEditorFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.3
 * JD-Core Version:    0.7.0.1
 */