package me.ele.uetool.dialog;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.base.Application;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.AddMinusEditItem.CustomAddMin;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.ViewKnife;

public class MultipleAttrsDialog$Adapter$AddMinusEditViewHolder
  extends MultipleAttrsDialog.Adapter.EditTextViewHolder<AddMinusEditItem>
{
  private AddMinusEditItem.CustomAddMin addMin;
  private View vAdd;
  private View vMinus;
  
  public MultipleAttrsDialog$Adapter$AddMinusEditViewHolder(View paramView)
  {
    super(paramView);
    this.vAdd = paramView.findViewById(JarResource.getIdByName("id", "add"));
    this.vMinus = paramView.findViewById(JarResource.getIdByName("id", "minus"));
    this.vAdd.setOnClickListener(new MultipleAttrsDialog.Adapter.AddMinusEditViewHolder.1(this));
    this.vMinus.setOnClickListener(new MultipleAttrsDialog.Adapter.AddMinusEditViewHolder.2(this));
  }
  
  private void allItemChange(int paramInt)
  {
    Toast.makeText(Application.getApplicationContext(), "修改值为： " + paramInt, 0).show();
    Iterator localIterator;
    Object localObject;
    if (((AddMinusEditItem)this.item).getType() == 2)
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      while (localIterator.hasNext())
      {
        localObject = (TextView)((Element)localIterator.next()).getView();
        float f = Float.valueOf(((TextView)localObject).getTextSize() + paramInt).floatValue();
        if (((TextView)localObject).getTextSize() != f) {
          ((TextView)localObject).setTextSize(Float.valueOf(DimenUtil.px2sp(f)).floatValue());
        }
      }
    }
    int i;
    if (((AddMinusEditItem)this.item).getType() == 4)
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      while (localIterator.hasNext())
      {
        localObject = ((Element)localIterator.next()).getView();
        i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getWidth()) + paramInt);
        if (Math.abs(i - ((View)localObject).getWidth()) >= ViewKnife.dip2px(1.0F))
        {
          ((View)localObject).getLayoutParams().width = i;
          ((View)localObject).requestLayout();
        }
      }
    }
    if (((AddMinusEditItem)this.item).getType() == 5)
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      while (localIterator.hasNext())
      {
        localObject = ((Element)localIterator.next()).getView();
        i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getHeight()) + paramInt);
        if (Math.abs(i - ((View)localObject).getHeight()) >= ViewKnife.dip2px(1.0F))
        {
          ((View)localObject).getLayoutParams().height = i;
          ((View)localObject).requestLayout();
        }
      }
    }
    if (((AddMinusEditItem)this.item).getType() == 6)
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      while (localIterator.hasNext())
      {
        localObject = ((Element)localIterator.next()).getView();
        i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getPaddingLeft()) + paramInt);
        if (Math.abs(i - ((View)localObject).getPaddingLeft()) >= ViewKnife.dip2px(1.0F)) {
          ((View)localObject).setPadding(i, ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
        }
      }
    }
    if (((AddMinusEditItem)this.item).getType() == 7)
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      while (localIterator.hasNext())
      {
        localObject = ((Element)localIterator.next()).getView();
        i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getPaddingRight()) + paramInt);
        if (Math.abs(i - ((View)localObject).getPaddingRight()) >= ViewKnife.dip2px(1.0F)) {
          ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), i, ((View)localObject).getPaddingBottom());
        }
      }
    }
    if (((AddMinusEditItem)this.item).getType() == 8)
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      while (localIterator.hasNext())
      {
        localObject = ((Element)localIterator.next()).getView();
        i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getPaddingTop()) + paramInt);
        if (Math.abs(i - ((View)localObject).getPaddingTop()) >= ViewKnife.dip2px(1.0F)) {
          ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), i, ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
        }
      }
    }
    if (((AddMinusEditItem)this.item).getType() == 9)
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      while (localIterator.hasNext())
      {
        localObject = ((Element)localIterator.next()).getView();
        i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getPaddingBottom()) + paramInt);
        if (Math.abs(i - ((View)localObject).getPaddingBottom()) >= ViewKnife.dip2px(1.0F)) {
          ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), i);
        }
      }
    }
    if (((AddMinusEditItem)this.item).getType() == 10)
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      if (localIterator.hasNext())
      {
        localObject = ((Element)localIterator.next()).getView();
        if (((View)localObject).getTranslationY() < 0.0F) {}
        for (i = -ViewKnife.px2dip(-((View)localObject).getTranslationY());; i = ViewKnife.px2dip(((View)localObject).getTranslationY()))
        {
          i = ViewKnife.dip2px(i + paramInt);
          Log.i("MultipleAttrsDialog", "allItemChange: " + i);
          ((View)localObject).setTranslationY(i);
          break;
        }
      }
    }
    else if (((AddMinusEditItem)this.item).getType() == 11)
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      if (localIterator.hasNext())
      {
        localObject = ((Element)localIterator.next()).getView();
        if (((View)localObject).getTranslationX() < 0.0F) {}
        for (i = -ViewKnife.px2dip(-((View)localObject).getTranslationX());; i = ViewKnife.px2dip(((View)localObject).getTranslationX()))
        {
          i = ViewKnife.dip2px(i + paramInt);
          Log.i("MultipleAttrsDialog", "allItemChange: " + i);
          ((View)localObject).setTranslationX(i);
          break;
        }
      }
    }
  }
  
  public static AddMinusEditViewHolder newInstance(ViewGroup paramViewGroup)
  {
    return new AddMinusEditViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_add_minus_edit"), paramViewGroup, false));
  }
  
  public void bindView(AddMinusEditItem paramAddMinusEditItem)
  {
    super.bindView(paramAddMinusEditItem);
  }
  
  public void setAddMin(AddMinusEditItem.CustomAddMin paramCustomAddMin)
  {
    this.addMin = paramCustomAddMin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.AddMinusEditViewHolder
 * JD-Core Version:    0.7.0.1
 */