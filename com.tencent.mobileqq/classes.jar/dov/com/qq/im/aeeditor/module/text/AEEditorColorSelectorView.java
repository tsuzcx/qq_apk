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
import android.widget.LinearLayout;
import com.microrapid.opencv.ImageMainColorData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavsticker.utils.CollectionUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.filter.AdapterUtil;
import dov.com.qq.im.aeeditor.util.AEExtractColorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorColorSelectorView
  extends LinearLayout
  implements AEEditorEditColorSelected
{
  public static final int a;
  public static final int b;
  private static final int jdField_c_of_type_Int = Color.parseColor("#ff292929");
  private static final int jdField_d_of_type_Int = Color.parseColor("#ffffffff");
  private static final int e = Color.parseColor("#ff7ebcdc");
  private static final int f = Color.parseColor("#ffecb48a");
  private static final int g = Color.parseColor("#fff5999e");
  private static final int h = Color.parseColor("#ffa684b8");
  private static final int i = Color.parseColor("#ff8db879");
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEEditorColorAdapter jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter;
  private AEEditorEditColorSelected jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorEditColorSelected;
  private final List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private final List<Float> b;
  private final List<Integer> jdField_c_of_type_JavaUtilList = new ArrayList();
  private final List<Integer> jdField_d_of_type_JavaUtilList = new ArrayList();
  
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
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    setOrientation(1);
    setGravity(16);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560852, this, true);
    c();
    a(paramContext);
  }
  
  public static Drawable a(View paramView, boolean paramBoolean, int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    int j;
    int m;
    if (paramBoolean)
    {
      j = 2131299129;
      m = paramView.getResources().getDimensionPixelSize(2131299127);
      if (!paramBoolean) {
        break label85;
      }
    }
    label85:
    for (int k = 0;; k = paramView.getResources().getDimensionPixelSize(2131299130))
    {
      k = m - k;
      localGradientDrawable.setColor(paramInt);
      localGradientDrawable.setStroke(paramView.getResources().getDimensionPixelSize(j), -1);
      localGradientDrawable.setSize(k, k);
      localGradientDrawable.setShape(1);
      return localGradientDrawable;
      j = 2131299130;
      break;
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131365221));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter = new AEEditorColorAdapter("adapter_fix", this.jdField_d_of_type_JavaUtilList, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter);
    paramView = new LinearLayoutManager(getContext(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
  }
  
  private void c()
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
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(jdField_d_of_type_Int));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(e));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(f));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(g));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(h));
    this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(i));
    d();
  }
  
  private void d()
  {
    this.jdField_d_of_type_JavaUtilList.clear();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(0) != null)) {
      this.jdField_d_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_d_of_type_JavaUtilList.addAll(this.jdField_c_of_type_JavaUtilList);
  }
  
  public List<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    AEQLog.a("AEEditorColorSelectorView", "[hideIntelligentRv]");
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      int j = 0;
      while (localIterator.hasNext())
      {
        if (((Integer)localIterator.next()).intValue() == paramInteger.intValue())
        {
          ThreadManager.getUIHandler().post(new AEEditorColorSelectorView.1(this, j));
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter.a(j);
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter.notifyDataSetChanged();
          return;
        }
        j += 1;
      }
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter.a(-1);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter.notifyDataSetChanged();
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ("adapter_extract".equals(paramString1)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter.a(-1);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter.notifyDataSetChanged();
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorEditColorSelected != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorEditColorSelected.a(paramString1, paramInt1, paramInt2, paramString2);
      }
      return;
      if ("adapter_fix".equals(paramString1)) {
        AdapterUtil.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramInt2, true);
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
          d();
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter.notifyDataSetChanged();
          continue;
        }
        localImageMainColorData = (ImageMainColorData)paramList.get(j);
      }
      finally {}
      ImageMainColorData localImageMainColorData;
      this.jdField_a_of_type_JavaUtilList.set(j, Integer.valueOf(AEExtractColorUtil.a(localImageMainColorData)));
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
  }
  
  public List<Float> c()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setColorSelectedListener(AEEditorEditColorSelected paramAEEditorEditColorSelected)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorEditColorSelected = paramAEEditorEditColorSelected;
  }
  
  public void setStickerId(String paramString)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView
 * JD-Core Version:    0.7.0.1
 */