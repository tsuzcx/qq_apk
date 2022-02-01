package com.tencent.mobileqq.leba.business;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.ArrayList;

public abstract interface ILebaListMgrItemBiz
{
  public abstract void a(ArrayList<LebaViewItem> paramArrayList);
  
  public abstract boolean a(RedTouch paramRedTouch, @NonNull LebaViewItem paramLebaViewItem, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.ILebaListMgrItemBiz
 * JD-Core Version:    0.7.0.1
 */