package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import bjlu;

public class SpeedProviderView
  extends ProviderView
  implements View.OnClickListener
{
  private bjlu a;
  protected View c;
  protected View d;
  protected View e;
  protected View f;
  
  public SpeedProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected int a()
  {
    return 2131560576;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560576, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131371752);
    this.c.setOnClickListener(this);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131371751);
    this.d.setOnClickListener(this);
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131371753);
    this.e.setOnClickListener(this);
    this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131371754);
    this.f.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    int i = j;
    switch (paramView.getId())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bjlu != null) {
        this.jdField_a_of_type_Bjlu.a(i);
      }
      return;
      i = 2;
      continue;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  public void setEditSpeedListener(bjlu parambjlu)
  {
    this.jdField_a_of_type_Bjlu = parambjlu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.SpeedProviderView
 * JD-Core Version:    0.7.0.1
 */