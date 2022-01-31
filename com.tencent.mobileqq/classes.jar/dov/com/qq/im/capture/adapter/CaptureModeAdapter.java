package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bhfp;
import bhfq;
import bhfr;
import java.util.ArrayList;
import java.util.List;

public class CaptureModeAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bhfr jdField_a_of_type_Bhfr;
  private List<bhfq> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = a(-1, 0.6F);
  private List<TextView> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public CaptureModeAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(int paramInt, float paramFloat)
  {
    return (int)(255.0F * paramFloat) << 24 | 0xFFFFFF & paramInt;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((bhfq)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramInt) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
      {
        TextView localTextView = (TextView)this.jdField_b_of_type_JavaUtilList.get(paramInt);
        if (this.jdField_a_of_type_Int == paramInt) {
          localTextView.setTextColor(-1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          localTextView.setTextColor(this.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    int i = this.jdField_b_of_type_JavaUtilList.size();
    int j = paramInt + 1;
    if ((paramInt >= 0) && (paramInt < i) && (j >= 0) && (j < i))
    {
      ((TextView)this.jdField_b_of_type_JavaUtilList.get(paramInt)).setTextColor(a(-1, (1.0F - paramFloat) * 0.4F + 0.6F));
      ((TextView)this.jdField_b_of_type_JavaUtilList.get(j)).setTextColor(a(-1, paramFloat * 0.4F + 0.6F));
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    if (localTextView != null)
    {
      if (paramBoolean) {
        localTextView.setTextColor(-1);
      }
    }
    else {
      return;
    }
    localTextView.setTextColor(this.jdField_b_of_type_Int);
  }
  
  public void a(bhfr parambhfr)
  {
    this.jdField_a_of_type_Bhfr = parambhfr;
  }
  
  public void a(List<bhfq> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = 0;
    if (i < paramList.size())
    {
      bhfq localbhfq = (bhfq)paramList.get(i);
      TextView localTextView = (TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494966, null);
      localTextView.setText(localbhfq.a());
      localTextView.setTag(Integer.valueOf(i));
      localTextView.setContentDescription(localbhfq.b());
      localTextView.setOnClickListener(new bhfp(this));
      if (localbhfq.a() != paramInt) {
        localTextView.setTextColor(this.jdField_b_of_type_Int);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilList.add(localTextView);
        i += 1;
        break;
        this.jdField_a_of_type_Int = i;
      }
    }
  }
  
  public void b(int paramInt)
  {
    TextView localTextView = (TextView)this.jdField_b_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    if (localTextView != null) {
      localTextView.setTextColor(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_Int = paramInt;
    localTextView = (TextView)this.jdField_b_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    if (localTextView != null) {
      localTextView.setTextColor(-1);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_b_of_type_JavaUtilList.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.jdField_b_of_type_JavaUtilList.get(paramInt));
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.CaptureModeAdapter
 * JD-Core Version:    0.7.0.1
 */