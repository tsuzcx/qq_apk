package com.tencent.mobileqq.troop.troopapps;

class TroopAppShortcutContainer$LoadingInfo
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public TroopAppShortcutContainer$LoadingInfo()
  {
    a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LoadingInfo a()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public LoadingInfo a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public LoadingInfo a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.b = true;
  }
  
  public boolean a()
  {
    return (!this.b) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != 0);
  }
  
  public LoadingInfo b()
  {
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.LoadingInfo
 * JD-Core Version:    0.7.0.1
 */