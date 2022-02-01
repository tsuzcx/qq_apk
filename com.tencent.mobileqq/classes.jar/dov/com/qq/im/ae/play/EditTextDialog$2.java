package dov.com.qq.im.ae.play;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.string.StringUtils;

class EditTextDialog$2
  implements View.OnClickListener
{
  EditTextDialog$2(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    if (EditTextDialog.access$300(this.this$0).getText().length() > EditTextDialog.access$000(this.this$0)) {
      QQToast.a(this.this$0.getContext(), this.this$0.getContext().getString(2131689779, new Object[] { Integer.valueOf(EditTextDialog.access$000(this.this$0)) }), 1).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (EditTextDialog.access$400(this.this$0) != null) {
        localObject2 = null;
      }
      try
      {
        localObject1 = EditTextDialog.access$300(this.this$0).getText().toString();
        localObject2 = localObject1;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object localObject1;
        label105:
        break label105;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = StringUtils.removeUTF8Emoji((String)localObject2);
      }
      Object localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ((String)localObject1).replaceAll("\\r|\\n", "");
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      EditTextDialog.access$400(this.this$0).onConfirmClick((String)localObject1);
      this.this$0.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextDialog.2
 * JD-Core Version:    0.7.0.1
 */