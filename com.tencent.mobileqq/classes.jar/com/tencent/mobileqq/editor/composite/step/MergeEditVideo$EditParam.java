package com.tencent.mobileqq.editor.composite.step;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;

public class MergeEditVideo$EditParam
{
  protected int a;
  protected PublishVideoEntry a;
  public boolean a;
  int b;
  int c;
  protected int d = -1;
  protected int e = -1;
  
  public MergeEditVideo$EditParam(int paramInt, PublishVideoEntry paramPublishVideoEntry)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry = new PublishVideoEntry();
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.copy(paramPublishVideoEntry);
    a(this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.saveMode);
  }
  
  private int b(int paramInt)
  {
    return 0;
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    if (paramInt != 1)
    {
      i = 2;
      if (paramInt != 2)
      {
        i = 3;
        if (paramInt != 3)
        {
          i = 4;
          if (paramInt != 4)
          {
            i = 5;
            if (paramInt != 5) {
              return 0;
            }
          }
        }
      }
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath = null;
  }
  
  public void a(int paramInt)
  {
    this.b = b(paramInt);
    this.c = a(paramInt);
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.MergeEditVideo.EditParam
 * JD-Core Version:    0.7.0.1
 */