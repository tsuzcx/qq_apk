import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class qtr
  extends ViewBase
{
  public static String a;
  private double jdField_a_of_type_Double = 0.18D;
  private int jdField_a_of_type_Int = 22;
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b = 115;
  private int c;
  private int d;
  private int e = 351;
  private int f = 1;
  private int g = 11;
  private int h = 3;
  private int i;
  private int j = 6;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ReadInJoyFriendsBiu";
  }
  
  public qtr(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.c = Utils.rp2px(this.jdField_a_of_type_Int);
    this.d = Utils.rp2px(this.b);
    this.e = Utils.rp2px(this.e);
    this.g = Utils.rp2px(this.g);
    this.f = Utils.rp2px(this.f);
    this.j = Utils.rp2px(this.j);
  }
  
  private int a()
  {
    return (int)((this.e - this.c) / (this.c * (1.0D - this.jdField_a_of_type_Double)) + 1.0D);
  }
  
  private void a()
  {
    int i1 = a();
    int i2 = (int)Math.ceil(this.jdField_a_of_type_JavaUtilArrayList.size() / i1);
    int m = 1;
    if (m <= i2)
    {
      int i3 = (m - 1) * i1;
      if (i3 + i1 <= this.jdField_a_of_type_JavaUtilArrayList.size()) {}
      for (int k = i3 + i1;; k = i3 + this.jdField_a_of_type_JavaUtilArrayList.size() % i1)
      {
        int n = k;
        if (k > this.h) {
          n = this.h;
        }
        a(i3 + 1, n, (m - 1) * this.c + this.g);
        m += 1;
        break;
      }
    }
    a(i2);
  }
  
  private void a(int paramInt)
  {
    int k;
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      k = this.jdField_a_of_type_JavaUtilArrayList.size();
      localObject = k + "人也Biu了";
      long l = pkh.a();
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() != 1) || (l != ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue())) {
        break label281;
      }
      localObject = "还Biu了" + this.i + anvx.a(2131712437);
    }
    label132:
    label183:
    label332:
    label347:
    label359:
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      k = a();
      int m;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > k)
      {
        m = k;
        if (k > this.h) {
          m = this.h;
        }
        if (m <= 1) {
          break label332;
        }
        k = (int)((m - 1) * (1.0D - this.jdField_a_of_type_Double) * this.c + this.c + this.d);
        if (k <= this.e) {
          break label347;
        }
      }
      for (paramInt = this.c * paramInt;; paramInt = (paramInt - 1) * this.c)
      {
        m = this.d;
        localObject = new FrameLayout.LayoutParams(this.d, -2);
        ((FrameLayout.LayoutParams)localObject).setMargins(k - m, paramInt + this.g, 0, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165438));
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(this.j, 0, 0, 0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        return;
        if (k <= this.h) {
          break label359;
        }
        localObject = anvx.a(2131712571) + k + "人也Biu了";
        break;
        k = this.jdField_a_of_type_JavaUtilArrayList.size();
        break label132;
        k = m * this.c + this.d;
        break label183;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = paramInt2 - 1;
    ReadInJoyHeadImageView localReadInJoyHeadImageView;
    FrameLayout.LayoutParams localLayoutParams1;
    int n;
    if (k >= paramInt1 - 1)
    {
      localReadInJoyHeadImageView = new ReadInJoyHeadImageView(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams1 = new FrameLayout.LayoutParams(this.c, this.c);
      n = (int)((k - paramInt1 + 1) * (1.0D - this.jdField_a_of_type_Double) * this.c);
      if (paramInt2 != this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label216;
      }
    }
    label216:
    for (int m = 20;; m = 0)
    {
      localLayoutParams1.setMargins(n, paramInt3, 0, m);
      localReadInJoyHeadImageView.setHeadImgByUin(((Long)this.jdField_a_of_type_JavaUtilArrayList.get(k)).longValue());
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(this.c + this.f * 2, this.c + this.f * 2);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams2.setMargins(n - this.f, paramInt3 - this.f, 0, m);
      localImageView.setBackgroundResource(2130849432);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localImageView, localLayoutParams2);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localReadInJoyHeadImageView, localLayoutParams1);
      k -= 1;
      break;
      return;
    }
  }
  
  private void a(Object paramObject)
  {
    do
    {
      try
      {
        if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        }
        this.i = 0;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        paramObject = (JSONObject)paramObject;
        Iterator localIterator = paramObject.keys();
        while (localIterator.hasNext())
        {
          long l = Long.parseLong(paramObject.get((String)localIterator.next()).toString());
          this.i += 1;
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(l))) {
            this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
          }
        }
        a();
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "parseUinList error:" + paramObject.toString());
        }
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "parseUinList :" + this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  private void b(Object paramObject)
  {
    int k = Utils.parseColor(paramObject.toString());
    if (k != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(k);
    }
  }
  
  private void c(Object paramObject)
  {
    Double localDouble = Utils.toDouble(paramObject);
    if (localDouble != null)
    {
      int k = Utils.dp2px(localDouble.doubleValue());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(k);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "setTextSize: fail to parse - " + paramObject);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool = super.setAttribute(paramInt, paramObject);
    switch (paramInt)
    {
    }
    do
    {
      return bool;
      a(paramObject);
      return bool;
      c(paramObject);
      return bool;
      b(paramObject);
      return bool;
      try
      {
        this.d = Utils.rp2px(Integer.valueOf(paramObject.toString()).intValue());
        return bool;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "parse STR_ID_BORDER_WIDTH error:" + paramObject.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qtr
 * JD-Core Version:    0.7.0.1
 */