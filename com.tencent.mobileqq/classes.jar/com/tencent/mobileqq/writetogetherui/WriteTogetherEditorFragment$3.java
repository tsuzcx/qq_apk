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
      QQToast.makeText(WriteTogetherEditorFragment.b(this.a), WriteTogetherEditorFragment.b(this.a).getResources().getString(2131918150), 0).show();
    }
    if (paramBoolean)
    {
      paramArrayOfObject = WriteTogetherEditorFragment.a(this.a, paramArrayOfObject);
      this.a.getQBaseActivity().setResult(15, paramArrayOfObject);
      this.a.getQBaseActivity().finish();
      WriteTogetherEditorFragment.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.3
 * JD-Core Version:    0.7.0.1
 */