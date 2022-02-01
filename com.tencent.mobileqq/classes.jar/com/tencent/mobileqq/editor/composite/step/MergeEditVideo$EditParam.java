package com.tencent.mobileqq.editor.composite.step;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;

public class MergeEditVideo$EditParam
{
  protected int a;
  protected PublishVideoEntry b;
  int c;
  int d;
  protected int e = -1;
  protected int f = -1;
  public boolean g = false;
  
  public MergeEditVideo$EditParam(int paramInt, PublishVideoEntry paramPublishVideoEntry)
  {
    this.a = paramInt;
    this.b = new PublishVideoEntry();
    this.b.copy(paramPublishVideoEntry);
    a(this.b.saveMode);
  }
  
  private int e(int paramInt)
  {
    return 0;
  }
  
  public void a()
  {
    this.b.doodlePath = null;
  }
  
  public void a(int paramInt)
  {
    this.c = e(paramInt);
    this.d = b(paramInt);
  }
  
  public int b(int paramInt)
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
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.MergeEditVideo.EditParam
 * JD-Core Version:    0.7.0.1
 */