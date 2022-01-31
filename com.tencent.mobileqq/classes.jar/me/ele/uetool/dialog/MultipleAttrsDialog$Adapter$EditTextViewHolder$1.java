package me.ele.uetool.dialog;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;
import me.ele.uetool.util.ViewKnife;

class MultipleAttrsDialog$Adapter$EditTextViewHolder$1
  implements TextWatcher
{
  MultipleAttrsDialog$Adapter$EditTextViewHolder$1(MultipleAttrsDialog.Adapter.EditTextViewHolder paramEditTextViewHolder) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == paramInt2) && (paramInt1 == 0)) {}
    Object localObject2;
    for (;;)
    {
      return;
      try
      {
        if (MultipleAttrsDialog.access$000() == this.this$0.getAdapterPosition())
        {
          if (((EditTextItem)this.this$0.item).getType() == -1)
          {
            localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Element)((Iterator)localObject1).next();
              ((EditTextItem)this.this$0.item).getCallBack().callBack((Element)localObject2, paramCharSequence.toString());
              ((Element)localObject2).reset();
            }
          }
          if (((EditTextItem)this.this$0.item).getType() != 1) {
            break label215;
          }
        }
      }
      catch (Exception paramCharSequence)
      {
        paramCharSequence.printStackTrace();
        return;
      }
    }
    Object localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Element)((Iterator)localObject1).next();
      Object localObject3 = (TextView)((Element)localObject2).getView();
      if (!TextUtils.equals(((TextView)localObject3).getText().toString(), paramCharSequence.toString())) {
        ((TextView)localObject3).setText(paramCharSequence.toString());
      }
      ((Element)localObject2).reset();
      continue;
      label215:
      float f;
      if (((EditTextItem)this.this$0.item).getType() == 2)
      {
        localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Element)((Iterator)localObject1).next();
          localObject3 = (TextView)((Element)localObject2).getView();
          f = Float.valueOf(paramCharSequence.toString()).floatValue();
          if (((TextView)localObject3).getTextSize() != f) {
            ((TextView)localObject3).setTextSize(Float.valueOf(DimenUtil.px2sp(f)).floatValue());
          }
          ((Element)localObject2).reset();
        }
      }
      if (((EditTextItem)this.this$0.item).getType() == 3)
      {
        paramCharSequence = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (paramCharSequence.hasNext())
        {
          localObject1 = (Element)paramCharSequence.next();
          localObject2 = (TextView)((Element)localObject1).getView();
          paramInt1 = Color.parseColor(this.this$0.vDetail.getText().toString());
          if (paramInt1 != ((TextView)localObject2).getCurrentTextColor())
          {
            MultipleAttrsDialog.Adapter.EditTextViewHolder.access$200(this.this$0).setBackgroundColor(paramInt1);
            ((TextView)localObject2).setTextColor(paramInt1);
          }
          ((Element)localObject1).reset();
        }
      }
      if (((EditTextItem)this.this$0.item).getType() == 4)
      {
        localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Element)((Iterator)localObject1).next();
          localObject3 = ((Element)localObject2).getView();
          paramInt1 = ViewKnife.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
          if (Math.abs(paramInt1 - ((View)localObject3).getWidth()) >= ViewKnife.dip2px(1.0F))
          {
            ((View)localObject3).getLayoutParams().width = paramInt1;
            ((View)localObject3).requestLayout();
          }
          ((Element)localObject2).reset();
        }
      }
      if (((EditTextItem)this.this$0.item).getType() == 5)
      {
        localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Element)((Iterator)localObject1).next();
          localObject3 = ((Element)localObject2).getView();
          paramInt1 = ViewKnife.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
          if (Math.abs(paramInt1 - ((View)localObject3).getHeight()) >= ViewKnife.dip2px(1.0F))
          {
            ((View)localObject3).getLayoutParams().height = paramInt1;
            ((View)localObject3).requestLayout();
          }
          ((Element)localObject2).reset();
        }
      }
      if (((EditTextItem)this.this$0.item).getType() == 6)
      {
        localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Element)((Iterator)localObject1).next();
          localObject3 = ((Element)localObject2).getView();
          paramInt1 = ViewKnife.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
          if (Math.abs(paramInt1 - ((View)localObject3).getPaddingLeft()) >= ViewKnife.dip2px(1.0F)) {
            ((View)localObject3).setPadding(paramInt1, ((View)localObject3).getPaddingTop(), ((View)localObject3).getPaddingRight(), ((View)localObject3).getPaddingBottom());
          }
          ((Element)localObject2).reset();
        }
      }
      if (((EditTextItem)this.this$0.item).getType() == 7)
      {
        localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Element)((Iterator)localObject1).next();
          localObject3 = ((Element)localObject2).getView();
          paramInt1 = ViewKnife.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
          if (Math.abs(paramInt1 - ((View)localObject3).getPaddingRight()) >= ViewKnife.dip2px(1.0F)) {
            ((View)localObject3).setPadding(((View)localObject3).getPaddingLeft(), ((View)localObject3).getPaddingTop(), paramInt1, ((View)localObject3).getPaddingBottom());
          }
          ((Element)localObject2).reset();
        }
      }
      if (((EditTextItem)this.this$0.item).getType() == 8)
      {
        localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Element)((Iterator)localObject1).next();
          localObject3 = ((Element)localObject2).getView();
          paramInt1 = ViewKnife.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
          if (Math.abs(paramInt1 - ((View)localObject3).getPaddingTop()) >= ViewKnife.dip2px(1.0F)) {
            ((View)localObject3).setPadding(((View)localObject3).getPaddingLeft(), paramInt1, ((View)localObject3).getPaddingRight(), ((View)localObject3).getPaddingBottom());
          }
          ((Element)localObject2).reset();
        }
      }
      if (((EditTextItem)this.this$0.item).getType() == 9)
      {
        localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Element)((Iterator)localObject1).next();
          localObject3 = ((Element)localObject2).getView();
          paramInt1 = ViewKnife.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue());
          if (Math.abs(paramInt1 - ((View)localObject3).getPaddingBottom()) >= ViewKnife.dip2px(1.0F)) {
            ((View)localObject3).setPadding(((View)localObject3).getPaddingLeft(), ((View)localObject3).getPaddingTop(), ((View)localObject3).getPaddingRight(), paramInt1);
          }
          ((Element)localObject2).reset();
        }
      }
      int[] arrayOfInt;
      if (((EditTextItem)this.this$0.item).getType() == 10)
      {
        localObject1 = ((EditTextItem)this.this$0.item).getElement().getView();
        localObject2 = ViewKnife.getMargin(((EditTextItem)this.this$0.item).getElement());
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue() - Integer.valueOf(DimenUtil.px2dip(localObject2[1])).intValue());
        f = ((View)localObject1).getTranslationY();
        ((View)localObject1).setTranslationY(paramInt1 + f);
        ((EditTextItem)this.this$0.item).getElement().reset();
        localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Element)((Iterator)localObject1).next();
          localObject3 = ((Element)localObject2).getView();
          arrayOfInt = ViewKnife.getMargin(((EditTextItem)this.this$0.item).getElement());
          paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue() - Integer.valueOf(DimenUtil.px2dip(arrayOfInt[1])).intValue());
          f = ((View)localObject3).getTranslationY();
          ((View)localObject3).setTranslationY(paramInt1 + f);
          ((Element)localObject2).reset();
        }
      }
      if (((EditTextItem)this.this$0.item).getType() == 11)
      {
        localObject1 = ((EditTextItem)this.this$0.item).getElement().getView();
        localObject2 = ViewKnife.getMargin(((EditTextItem)this.this$0.item).getElement());
        paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue() - Integer.valueOf(DimenUtil.px2dip(localObject2[0])).intValue());
        f = ((View)localObject1).getTranslationX();
        ((View)localObject1).setTranslationX(paramInt1 + f);
        ((EditTextItem)this.this$0.item).getElement().reset();
        localObject1 = MultipleAttrsDialog.Adapter.access$100().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Element)((Iterator)localObject1).next();
          localObject3 = ((Element)localObject2).getView();
          arrayOfInt = ViewKnife.getMargin(((EditTextItem)this.this$0.item).getElement());
          paramInt1 = DimenUtil.dip2px(Integer.valueOf(paramCharSequence.toString()).intValue() - Integer.valueOf(DimenUtil.px2dip(arrayOfInt[0])).intValue());
          f = ((View)localObject3).getTranslationY();
          ((View)localObject3).setTranslationY(paramInt1 + f);
          ((Element)localObject2).reset();
        }
      }
    }
    MultipleAttrsDialog.access$300().refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.EditTextViewHolder.1
 * JD-Core Version:    0.7.0.1
 */