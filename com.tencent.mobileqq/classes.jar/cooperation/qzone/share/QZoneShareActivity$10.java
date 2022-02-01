package cooperation.qzone.share;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.BaseApplication;

class QZoneShareActivity$10
  implements TextWatcher
{
  QZoneShareActivity$10(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 == 1) || (paramInt2 == 2)) && (paramInt3 == 0)) {
      try
      {
        QZoneShareActivity.access$1402(this.this$0, QZoneShareActivity.access$1600(this.this$0, paramCharSequence, paramInt1 + paramInt2));
        if (QZoneShareActivity.access$1400(this.this$0) == -1)
        {
          QZoneShareActivity.access$1100(this.this$0);
          return;
        }
        QZoneShareActivity.access$1502(this.this$0, paramInt1);
        QZoneShareActivity.access$1202(this.this$0, paramCharSequence.toString().substring(QZoneShareActivity.access$1400(this.this$0), QZoneShareActivity.access$1500(this.this$0) + paramInt2));
        return;
      }
      catch (Exception paramCharSequence)
      {
        QZoneShareActivity.access$1100(this.this$0);
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.mViewEdit.removeTextChangedListener(this);
    if (paramCharSequence == null)
    {
      this.this$0.mViewEdit.addTextChangedListener(this);
      QZoneShareActivity.access$1100(this.this$0);
      return;
    }
    if ((paramInt3 == 1) && (paramInt2 == 0) && (paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@")))
    {
      this.this$0.hideKeyboardAndEmo(false);
      this.this$0.isInputAt = true;
      paramCharSequence = new Intent(BaseApplication.getContext(), SelectMemberActivity.class);
      paramCharSequence.putExtra("param_only_friends", true);
      paramCharSequence.putExtra("param_min", 1);
      this.this$0.startActivityForResult(paramCharSequence, 1000);
    }
    if (QZoneShareActivity.access$1300(this.this$0, QZoneShareActivity.access$1200(this.this$0), false)) {
      this.this$0.mViewEdit.getEditableText().delete(QZoneShareActivity.access$1400(this.this$0), QZoneShareActivity.access$1500(this.this$0));
    }
    QZoneShareActivity.access$1100(this.this$0);
    this.this$0.onTextCountChange();
    this.this$0.mViewEdit.addTextChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.10
 * JD-Core Version:    0.7.0.1
 */