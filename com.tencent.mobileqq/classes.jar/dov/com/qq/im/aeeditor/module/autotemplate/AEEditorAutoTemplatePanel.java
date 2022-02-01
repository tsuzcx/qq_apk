package dov.com.qq.im.aeeditor.module.autotemplate;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.manage.AEditorMaterialManager;
import dov.com.qq.im.aeeditor.manage.AEditorMaterialManager.RecommendListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class AEEditorAutoTemplatePanel
  extends FrameLayout
  implements AEditorMaterialManager.RecommendListener, AEAutoTemplateAdapter.ReloadListener
{
  private int jdField_a_of_type_Int;
  private final MutableLiveData<AEAutoTemplateRet> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AEAutoTemplateAdapter.OnItemClickListener jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter$OnItemClickListener;
  private AEAutoTemplateAdapter jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter;
  private AEAutoTemplateCategoryAdapter jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter;
  private List<MetaCategory> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private final MutableLiveData<Boolean> jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d = false;
  
  public AEEditorAutoTemplatePanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorAutoTemplatePanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorAutoTemplatePanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private AEEditorAutoTemplateBean a(MetaMaterial paramMetaMaterial, String paramString)
  {
    AEEditorAutoTemplateBean localAEEditorAutoTemplateBean = new AEEditorAutoTemplateBean();
    localAEEditorAutoTemplateBean.id = paramMetaMaterial.id;
    if (paramMetaMaterial.additionalFields == null) {}
    for (localAEEditorAutoTemplateBean.name = "";; localAEEditorAutoTemplateBean.name = ((String)paramMetaMaterial.additionalFields.get("name")))
    {
      localAEEditorAutoTemplateBean.thumbUrl = paramMetaMaterial.thumbUrl;
      localAEEditorAutoTemplateBean.packageUrl = paramMetaMaterial.packageUrl;
      localAEEditorAutoTemplateBean.packageMd5 = paramMetaMaterial.packageMd5;
      localAEEditorAutoTemplateBean.parentId = paramString;
      return localAEEditorAutoTemplateBean;
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    View localView = View.inflate(paramContext, 2131558566, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131377420));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131377431));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369609));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setAutoMeasureEnabled(false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = paramRecyclerView.getChildLayoutPosition(paramRecyclerView.getChildAt(0));
    int j = paramRecyclerView.getChildLayoutPosition(paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1));
    if (paramInt < i) {
      paramRecyclerView.smoothScrollToPosition(paramInt);
    }
    do
    {
      return;
      if (paramInt > j) {
        break;
      }
      paramInt -= i;
    } while ((paramInt < 0) || (paramInt >= paramRecyclerView.getChildCount()));
    paramRecyclerView.smoothScrollBy(paramRecyclerView.getChildAt(paramInt).getLeft(), 0);
    return;
    paramRecyclerView.smoothScrollToPosition(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.c = true;
  }
  
  private int b(String paramString, List<MetaCategory> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (paramString.equals(((MetaCategory)paramList.get(i)).id)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((MetaCategory)this.jdField_a_of_type_JavaUtilList.get(0)).materials = AEditorMaterialManager.a().a;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator1.hasNext())
      {
        MetaCategory localMetaCategory = (MetaCategory)localIterator1.next();
        if (localMetaCategory.materials != null)
        {
          Iterator localIterator2 = localMetaCategory.materials.iterator();
          while (localIterator2.hasNext()) {
            localArrayList.add(a((MetaMaterial)localIterator2.next(), localMetaCategory.id));
          }
        }
      }
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter.a(localArrayList, AEditorMaterialManager.a().a.size());
      }
    }
  }
  
  public int a(String paramString, List<AEEditorAutoTemplateBean> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (paramString.equals(((AEEditorAutoTemplateBean)paramList.get(i)).parentId)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public MutableLiveData<AEAutoTemplateRet> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new AEEditorAutoTemplatePanel.6(this));
  }
  
  public void a(AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter.a(paramAEEditorAutoTemplateBean);
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new AEEditorAutoTemplatePanel.7(this));
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.postValue(Boolean.valueOf(true));
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      e();
      AEditorMaterialManager.a().a(new WeakReference(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter = new AEAutoTemplateCategoryAdapter();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter);
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter = new AEAutoTemplateAdapter();
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter.a(this);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter);
    this.jdField_a_of_type_JavaUtilList = AEditorMaterialManager.a().b();
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter.a(this.jdField_a_of_type_JavaUtilList);
    g();
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter.a(new AEEditorAutoTemplatePanel.1(this));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new AEEditorAutoTemplatePanel.2(this));
    AEEditorAutoTemplatePanel.3 local3 = new AEEditorAutoTemplatePanel.3(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter.a(local3);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorAutoTemplatePanel.4(this));
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter.a(new AEEditorAutoTemplatePanel.5(this));
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter.a(0);
  }
  
  public void f()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter.a();
  }
  
  public void setDownLoadPackageListener(AEAutoTemplateAdapter.DownLoadPackageListener paramDownLoadPackageListener)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter.a(paramDownLoadPackageListener);
    }
  }
  
  public void setHasTemplate(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setOnPanelItemClickListener(AEAutoTemplateAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter$OnItemClickListener = paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel
 * JD-Core Version:    0.7.0.1
 */