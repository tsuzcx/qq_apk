package com.tencent.mobileqq.receipt;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.widget.ActionSheet;
import java.lang.ref.WeakReference;

class ReceiptMessageDetailFragment$OnTextLongClickedListener
  implements View.OnLongClickListener
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  
  private ReceiptMessageDetailFragment$OnTextLongClickedListener(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = (ReceiptMessageDetailFragment)this.a.get();
    if ((paramView != null) && (paramView.isAdded()))
    {
      ActionSheet localActionSheet = ActionSheet.create(paramView.getBaseActivity());
      localActionSheet.addButton(2131888241);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new ReceiptMessageDetailFragment.OnTextLongClickedListener.1(this, paramView, localActionSheet));
      localActionSheet.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.OnTextLongClickedListener
 * JD-Core Version:    0.7.0.1
 */