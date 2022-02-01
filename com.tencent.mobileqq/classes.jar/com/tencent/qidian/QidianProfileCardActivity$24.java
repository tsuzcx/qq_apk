package com.tencent.qidian;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.qidian.data.PublicAccountItem;

class QidianProfileCardActivity$24
  implements View.OnLongClickListener
{
  QidianProfileCardActivity$24(QidianProfileCardActivity paramQidianProfileCardActivity, Drawable paramDrawable, PublicAccountItem paramPublicAccountItem) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)) {
      QidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, (URLDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.b);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.24
 * JD-Core Version:    0.7.0.1
 */