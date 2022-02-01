package dov.com.qq.im.aeeditor.module.filter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorFilterControlPanel
  extends FrameLayout
  implements View.OnClickListener, FiltersAdapter.FilterListener
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorFilterControlPanel.class.getSimpleName();
  private int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEEditorFilterBean jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean = AEEditorFilterBean.createAiFilterInstance();
  private AEEditorFilterControlPanel.FilterControlListener jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener;
  private FilterChangedComparator jdField_a_of_type_DovComQqImAeeditorModuleFilterFilterChangedComparator;
  private FiltersAdapter jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter;
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private AEEditorFilterBean jdField_b_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean = AEEditorFilterBean.createNonFilterInstance();
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = -1;
  private AEEditorFilterBean jdField_c_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean = null;
  
  public AEEditorFilterControlPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorFilterControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorFilterControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private AEFilterExtendBean a(String paramString)
  {
    try
    {
      paramString = (AEFilterExtendBean)new Gson().fromJson(paramString, new AEEditorFilterControlPanel.3(this).getType());
      return paramString;
    }
    catch (JsonSyntaxException paramString)
    {
      AEQLog.d(jdField_a_of_type_JavaLangString, "parse effect json exception: " + paramString.toString());
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    if (getContext() != null) {
      return getContext().getString(paramInt);
    }
    return "";
  }
  
  private void a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    String str1 = paramAEEditorFilterBean.getEffectExtendBean().getLutID();
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = AEEditorResourceManager.a().a(paramAEEditorFilterBean);
      if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
      {
        b(paramInt, paramAEEditorFilterBean);
        return;
      }
      if (!NetworkUtil.a())
      {
        QQToast.a(getContext(), a(2131694508), 0).a();
        return;
      }
      if ((paramAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)) {
        b(a(2131691912));
      }
      AEEditorResourceManager.a().a(str1, new AEEditorFilterControlPanel.5(this, paramAEEditorFilterBean, paramInt));
      return;
    }
    b(paramInt, paramAEEditorFilterBean);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
    View localView = View.inflate(paramContext, 2131558578, this);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131377220);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localView.findViewById(2131366990));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new AEEditorFilterControlPanel.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362925));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131366989));
    paramContext = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
  }
  
  private void a(String paramString, int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    paramString = new AEEditorFilterControlPanel.4(this, paramString, paramAEEditorFilterBean, paramInt);
    ThreadManager.getFileThreadHandler().post(paramString);
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new AEEditorFilterControlPanel.8(this));
  }
  
  private void b(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    ThreadManager.getUIHandler().post(new AEEditorFilterControlPanel.6(this, paramInt, paramAEEditorFilterBean));
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorFilterControlPanel.7(this, paramString));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter.a();
  }
  
  public AEEditorFilterBean a()
  {
    return this.jdField_c_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean;
  }
  
  public List<AEEditorFilterBean> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter = new FiltersAdapter(this.jdField_a_of_type_JavaUtilList, 0, this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter.b(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(String paramString)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "selectFilter---" + paramString);
    if (TextUtils.isEmpty(paramString)) {}
    label104:
    for (;;)
    {
      return;
      int i = 0;
      for (;;)
      {
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label104;
        }
        if (paramString.equals(((AEEditorFilterBean)this.jdField_a_of_type_JavaUtilList.get(i)).getEffectId()))
        {
          if (!a(i, (AEEditorFilterBean)this.jdField_a_of_type_JavaUtilList.get(i))) {
            break;
          }
          a(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    while ((paramBoolean) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0;
  }
  
  public boolean a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_c_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean = paramAEEditorFilterBean;
      if (paramAEEditorFilterBean.type != AEEditorFilterBean.FilterID.AIFilter) {
        break label133;
      }
      AEQLog.b(jdField_a_of_type_JavaLangString, "select ai filter");
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener != null)
      {
        this.jdField_b_of_type_Boolean = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener.f();
        AEBaseDataReporter.a().b(paramAEEditorFilterBean.getEffectId());
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFilterChangedComparator != null) {
          bool = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFilterChangedComparator.a(this.jdField_c_of_type_Int, paramInt);
        }
        if ((bool) && (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener != null)) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener.z();
        }
        this.jdField_c_of_type_Int = paramInt;
      }
      return this.jdField_b_of_type_Boolean;
      label133:
      if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NON)
      {
        AEQLog.b(jdField_a_of_type_JavaLangString, "select none filter");
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener != null)
        {
          this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener.w();
          AEBaseDataReporter.a().b(paramAEEditorFilterBean.getEffectId());
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.CLIENT)
      {
        AEQLog.b(jdField_a_of_type_JavaLangString, "select color filter: " + paramAEEditorFilterBean.getEffectId());
        String str = AEEditorResourceManager.a().b(paramAEEditorFilterBean);
        this.jdField_b_of_type_Boolean = false;
        if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
        {
          a(str, paramInt, paramAEEditorFilterBean);
        }
        else if (!NetworkUtil.a())
        {
          QQToast.a(getContext(), a(2131694508), 0).a();
        }
        else
        {
          if ((paramAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)) {
            b(a(2131691912));
          }
          AEEditorDownloadResBean localAEEditorDownloadResBean = AEEditorEffectUtils.a(paramAEEditorFilterBean);
          AEEditorResourceManager.a().a(localAEEditorDownloadResBean);
          AEEditorResourceManager.a().a(localAEEditorDownloadResBean, new AEEditorFilterControlPanel.2(this, paramAEEditorFilterBean, paramInt, str));
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)
      {
        AEQLog.b(jdField_a_of_type_JavaLangString, "select comics filter");
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener != null)
        {
          this.jdField_b_of_type_Boolean = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener.a(paramInt, paramAEEditorFilterBean);
          AEBaseDataReporter.a().b(paramAEEditorFilterBean.getEffectId());
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0;
  }
  
  public void c(boolean paramBoolean)
  {
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localSeekBar.setVisibility(i);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      return;
    }
  }
  
  public boolean c()
  {
    return a() == 1;
  }
  
  public boolean d()
  {
    return a() == 0;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_AndroidWidgetImageView.isEnabled()) && (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener != null) && ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener instanceof AEEditorFilterControlPanel.ImageFilterControlListener))) {
        ((AEEditorFilterControlPanel.ImageFilterControlListener)this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener).v();
      }
    }
  }
  
  public void setFilterChangedComparator(FilterChangedComparator paramFilterChangedComparator)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFilterChangedComparator = paramFilterChangedComparator;
  }
  
  public void setFilterControlListener(AEEditorFilterControlPanel.FilterControlListener paramFilterControlListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener = paramFilterControlListener;
  }
  
  public void setFiltersData(List<AEEditorFilterBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter.notifyDataSetChanged();
    }
  }
  
  public void setPageId(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setSeekBarValue(float paramFloat)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel
 * JD-Core Version:    0.7.0.1
 */