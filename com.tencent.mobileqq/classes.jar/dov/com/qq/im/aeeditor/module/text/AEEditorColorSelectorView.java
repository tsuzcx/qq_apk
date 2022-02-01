package dov.com.qq.im.aeeditor.module.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import bpam;
import bphy;
import bpjl;
import bpjo;
import bpjp;
import bpkv;
import com.microrapid.opencv.ImageMainColorData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorColorSelectorView
  extends FrameLayout
  implements bpjp
{
  public static final int a;
  public static final int b;
  private static final int jdField_c_of_type_Int = Color.parseColor("#ff292929");
  private static final int d = Color.parseColor("#ffffffff");
  private static final int e = Color.parseColor("#ff7ebcdc");
  private static final int f = Color.parseColor("#ffecb48a");
  private static final int g = Color.parseColor("#fff5999e");
  private static final int h = Color.parseColor("#ffa684b8");
  private static final int i = Color.parseColor("#ff8db879");
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bpjl jdField_a_of_type_Bpjl;
  private bpjp jdField_a_of_type_Bpjp;
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private bpjl jdField_b_of_type_Bpjl;
  private List<Float> jdField_b_of_type_JavaUtilList = new ArrayList();
  private List<Integer> jdField_c_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Int = Color.parseColor("#ffb8b9c7");
    jdField_b_of_type_Int = Color.parseColor("#ff262626");
  }
  
  public AEEditorColorSelectorView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorColorSelectorView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560823, this, true);
    e();
    a(paramContext);
  }
  
  public static Drawable a(View paramView, boolean paramBoolean, int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    int j;
    int m;
    if (paramBoolean)
    {
      j = 2131298973;
      m = paramView.getResources().getDimensionPixelSize(2131298970);
      if (!paramBoolean) {
        break label85;
      }
    }
    label85:
    for (int k = 0;; k = paramView.getResources().getDimensionPixelSize(2131298974))
    {
      k = m - k;
      localGradientDrawable.setColor(paramInt);
      localGradientDrawable.setStroke(paramView.getResources().getDimensionPixelSize(j), -1);
      localGradientDrawable.setSize(k, k);
      localGradientDrawable.setShape(1);
      return localGradientDrawable;
      j = 2131298974;
      break;
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131368759));
    this.jdField_a_of_type_Bpjl = new bpjl("adapter_extract", this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bpjl);
    bpjo localbpjo = new bpjo(this, getContext(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localbpjo);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364736);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379640));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131364974));
    this.jdField_b_of_type_Bpjl = new bpjl("adapter_fix", this.jdField_c_of_type_JavaUtilList, this);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_b_of_type_Bpjl);
    paramView = new LinearLayoutManager(getContext(), 0, false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(null);
    this.jdField_a_of_type_JavaUtilList.add(null);
    this.jdField_a_of_type_JavaUtilList.add(null);
    this.jdField_a_of_type_JavaUtilList.add(null);
    this.jdField_b_of_type_JavaUtilList.add(Float.valueOf(0.5F));
    this.jdField_b_of_type_JavaUtilList.add(Float.valueOf(0.5F));
    this.jdField_b_of_type_JavaUtilList.add(Float.valueOf(0.5F));
    this.jdField_b_of_type_JavaUtilList.add(Float.valueOf(0.5F));
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(jdField_c_of_type_Int));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(d));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(e));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(f));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(g));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(h));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(i));
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    bpam.a("AEEditorColorSelectorView", "[hideIntelligentRv]");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(Integer paramInteger)
  {
    int k = 0;
    if (paramInteger != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          Integer localInteger = (Integer)localIterator.next();
          if ((localInteger != null) && (localInteger.intValue() == paramInteger.intValue()))
          {
            this.jdField_b_of_type_Bpjl.a(-1);
            this.jdField_b_of_type_Bpjl.notifyDataSetChanged();
            this.jdField_a_of_type_Bpjl.a(j);
            this.jdField_a_of_type_Bpjl.notifyDataSetChanged();
            return;
          }
          j += 1;
        }
      }
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      int j = k;
      while (localIterator.hasNext())
      {
        if (((Integer)localIterator.next()).intValue() == paramInteger.intValue())
        {
          ThreadManager.getUIHandler().post(new AEEditorColorSelectorView.2(this, j));
          this.jdField_b_of_type_Bpjl.a(j);
          this.jdField_b_of_type_Bpjl.notifyDataSetChanged();
          this.jdField_a_of_type_Bpjl.a(-1);
          this.jdField_a_of_type_Bpjl.notifyDataSetChanged();
          return;
        }
        j += 1;
      }
    }
    this.jdField_a_of_type_Bpjl.a(-1);
    this.jdField_a_of_type_Bpjl.notifyDataSetChanged();
    this.jdField_b_of_type_Bpjl.a(-1);
    this.jdField_b_of_type_Bpjl.notifyDataSetChanged();
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ("adapter_extract".equals(paramString1)) {
      this.jdField_b_of_type_Bpjl.a(-1);
    }
    for (;;)
    {
      this.jdField_b_of_type_Bpjl.notifyDataSetChanged();
      this.jdField_a_of_type_Bpjl.notifyDataSetChanged();
      if (this.jdField_a_of_type_Bpjp != null) {
        this.jdField_a_of_type_Bpjp.a(paramString1, paramInt1, paramInt2, paramString2);
      }
      return;
      if ("adapter_fix".equals(paramString1))
      {
        bphy.a(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView, paramInt2, true);
        this.jdField_a_of_type_Bpjl.a(-1);
      }
    }
  }
  
  public void a(List<ImageMainColorData> paramList, boolean paramBoolean)
  {
    for (;;)
    {
      int j;
      try
      {
        if ((this.jdField_a_of_type_Boolean) || (paramBoolean))
        {
          paramBoolean = CollectionUtil.isEmptyList(paramList);
          if (!paramBoolean) {}
        }
        else
        {
          return;
        }
        j = 0;
        if ((j >= this.jdField_a_of_type_JavaUtilList.size()) || (paramList.size() <= j))
        {
          if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
            continue;
          }
          this.jdField_a_of_type_Bpjl.notifyDataSetChanged();
          continue;
        }
        localImageMainColorData = (ImageMainColorData)paramList.get(j);
      }
      finally {}
      ImageMainColorData localImageMainColorData;
      this.jdField_a_of_type_JavaUtilList.set(j, Integer.valueOf(bpkv.a(localImageMainColorData)));
      this.jdField_b_of_type_JavaUtilList.set(j, Float.valueOf(localImageMainColorData.l));
      j += 1;
    }
  }
  
  public List<Integer> b()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public List<Float> c()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bpjl != null)
    {
      this.jdField_a_of_type_Bpjl.a(false);
      this.jdField_a_of_type_Bpjl.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(null);
    this.jdField_a_of_type_JavaUtilList.add(null);
    this.jdField_a_of_type_JavaUtilList.add(null);
    this.jdField_a_of_type_JavaUtilList.add(null);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setColorSelectedListener(bpjp parambpjp)
  {
    this.jdField_a_of_type_Bpjp = parambpjp;
  }
  
  public void setStickerId(String paramString)
  {
    if (this.jdField_a_of_type_Bpjl != null) {
      this.jdField_a_of_type_Bpjl.a(paramString);
    }
    if (this.jdField_b_of_type_Bpjl != null) {
      this.jdField_b_of_type_Bpjl.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView
 * JD-Core Version:    0.7.0.1
 */