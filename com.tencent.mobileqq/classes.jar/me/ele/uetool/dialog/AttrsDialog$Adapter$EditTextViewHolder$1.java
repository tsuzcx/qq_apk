package me.ele.uetool.dialog;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;
import me.ele.uetool.util.ViewKnife;

class AttrsDialog$Adapter$EditTextViewHolder$1
  implements TextWatcher
{
  AttrsDialog$Adapter$EditTextViewHolder$1(AttrsDialog.Adapter.EditTextViewHolder paramEditTextViewHolder) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        if (((EditTextItem)this.this$0.item).getCallBack() != null)
        {
          Log.d("CALLBACK", "onTextChanged: " + paramCharSequence.toString());
          ((EditTextItem)this.this$0.item).getCallBack().callBack(((EditTextItem)this.this$0.item).getElement(), paramCharSequence.toString());
        }
        if (((EditTextItem)this.this$0.item).getType() != 1) {
          continue;
        }
        localTextView = (TextView)((EditTextItem)this.this$0.item).getElement().getView();
        if (!TextUtils.equals(localTextView.getText().toString(), paramCharSequence.toString())) {
          localTextView.setText(paramCharSequence.toString());
        }
      }
      catch (Exception localException)
      {
        TextView localTextView;
        localException.printStackTrace();
        continue;
        if (((EditTextItem)this.this$0.item).getType() != 3) {
          continue;
        }
        Object localObject = (TextView)((EditTextItem)this.this$0.item).getElement().getView();
        paramInt1 = Color.parseColor(this.this$0.vDetail.getText().toString());
        if (paramInt1 == ((TextView)localObject).getCurrentTextColor()) {
          continue;
        }
        AttrsDialog.Adapter.EditTextViewHolder.access$000(this.this$0).setBackgroundColor(paramInt1);
        ((TextView)localObject).setTextColor(paramInt1);
        continue;
        if (((EditTextItem)this.this$0.item).getType() != 4) {
          continue;
        }
        localObject = ((EditTextItem)this.this$0.item).getElement().getView();
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
        if (Math.abs(paramInt1 - ((View)localObject).getWidth()) < DimenUtil.dip2px(1.0F)) {
          continue;
        }
        ((View)localObject).getLayoutParams().width = paramInt1;
        ((View)localObject).requestLayout();
        continue;
        if (((EditTextItem)this.this$0.item).getType() != 5) {
          continue;
        }
        localObject = ((EditTextItem)this.this$0.item).getElement().getView();
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
        if (Math.abs(paramInt1 - ((View)localObject).getHeight()) < DimenUtil.dip2px(1.0F)) {
          continue;
        }
        ((View)localObject).getLayoutParams().height = paramInt1;
        ((View)localObject).requestLayout();
        continue;
        if (((EditTextItem)this.this$0.item).getType() != 6) {
          continue;
        }
        localObject = ((EditTextItem)this.this$0.item).getElement().getView();
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
        if (Math.abs(paramInt1 - ((View)localObject).getPaddingLeft()) < DimenUtil.dip2px(1.0F)) {
          continue;
        }
        ((View)localObject).setPadding(paramInt1, ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
        continue;
        if (((EditTextItem)this.this$0.item).getType() != 7) {
          continue;
        }
        localObject = ((EditTextItem)this.this$0.item).getElement().getView();
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
        if (Math.abs(paramInt1 - ((View)localObject).getPaddingRight()) < DimenUtil.dip2px(1.0F)) {
          continue;
        }
        ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), paramInt1, ((View)localObject).getPaddingBottom());
        continue;
        if (((EditTextItem)this.this$0.item).getType() != 8) {
          continue;
        }
        localObject = ((EditTextItem)this.this$0.item).getElement().getView();
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
        if (Math.abs(paramInt1 - ((View)localObject).getPaddingTop()) < DimenUtil.dip2px(1.0F)) {
          continue;
        }
        ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), paramInt1, ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
        continue;
        if (((EditTextItem)this.this$0.item).getType() != 9) {
          continue;
        }
        localObject = ((EditTextItem)this.this$0.item).getElement().getView();
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
        if (Math.abs(paramInt1 - ((View)localObject).getPaddingBottom()) < DimenUtil.dip2px(1.0F)) {
          continue;
        }
        ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), paramInt1);
        continue;
        if (((EditTextItem)this.this$0.item).getType() != 10) {
          continue;
        }
        localObject = ((EditTextItem)this.this$0.item).getElement().getView();
        int[] arrayOfInt = ViewKnife.getMargin(((EditTextItem)this.this$0.item).getElement());
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue() - Integer.valueOf(DimenUtil.px2dip(arrayOfInt[1])).intValue());
        float f = ((View)localObject).getTranslationY();
        ((View)localObject).setTranslationY(paramInt1 + f);
        ((EditTextItem)this.this$0.item).getElement().reset();
        continue;
        if (((EditTextItem)this.this$0.item).getType() != 11) {
          continue;
        }
        localObject = ((EditTextItem)this.this$0.item).getElement().getView();
        arrayOfInt = ViewKnife.getMargin(((EditTextItem)this.this$0.item).getElement());
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue() - Integer.valueOf(DimenUtil.px2dip(arrayOfInt[0])).intValue());
        f = ((View)localObject).getTranslationX();
        ((View)localObject).setTranslationX(paramInt1 + f);
        ((EditTextItem)this.this$0.item).getElement().reset();
        continue;
      }
      ((EditTextItem)this.this$0.item).setDetail(paramCharSequence.toString());
      if (AttrsDialog.access$100() != null) {
        AttrsDialog.access$100().refresh();
      }
      return;
      if (((EditTextItem)this.this$0.item).getType() != 2) {
        continue;
      }
      localTextView = (TextView)((EditTextItem)this.this$0.item).getElement().getView();
      f = Float.valueOf(paramCharSequence.toString()).floatValue();
      if (localTextView.getTextSize() != f) {
        localTextView.setTextSize(Float.valueOf(DimenUtil.px2sp(f)).floatValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.EditTextViewHolder.1
 * JD-Core Version:    0.7.0.1
 */