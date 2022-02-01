package com.tencent.mobileqq.troop.createNewTroop;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class AbsNewTroopBaseView
  extends FrameLayout
{
  protected QQAppInterface a;
  public NewTroopCreateActivity a;
  
  public AbsNewTroopBaseView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AbsNewTroopBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsNewTroopBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a() {}
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(NewTroopCreateActivity paramNewTroopCreateActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity = paramNewTroopCreateActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramNewTroopCreateActivity.app;
  }
  
  public void a(boolean paramBoolean) {}
  
  protected boolean a()
  {
    return false;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void d() {}
  
  protected void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.AbsNewTroopBaseView
 * JD-Core Version:    0.7.0.1
 */