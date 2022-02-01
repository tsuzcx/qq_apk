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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import bhnv;
import bozr;
import bpam;
import bpan;
import bpdr;
import bphl;
import bphm;
import bphn;
import bpho;
import bphp;
import bphq;
import bphr;
import bphx;
import bphy;
import bpib;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorFilterControlPanel
  extends FrameLayout
  implements View.OnClickListener, bpib
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorFilterControlPanel.class.getSimpleName();
  private int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bphp jdField_a_of_type_Bphp;
  private bphx jdField_a_of_type_Bphx;
  private bphy jdField_a_of_type_Bphy;
  private AEEditorFilterBean jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean = AEEditorFilterBean.createAiFilterInstance();
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private AEEditorFilterBean jdField_b_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean = AEEditorFilterBean.createNonFilterInstance();
  private boolean jdField_b_of_type_Boolean = true;
  private AEEditorFilterBean c;
  
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
      paramString = (AEFilterExtendBean)new Gson().fromJson(paramString, new bphn(this).getType());
      return paramString;
    }
    catch (JsonSyntaxException paramString)
    {
      bpam.d(jdField_a_of_type_JavaLangString, "parse effect json exception: " + paramString.toString());
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
      String str2 = bphr.a().a(paramAEEditorFilterBean);
      if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
      {
        b(paramInt, paramAEEditorFilterBean);
        return;
      }
      if (!bhnv.a())
      {
        QQToast.a(getContext(), a(2131694006), 0).a();
        return;
      }
      if ((paramAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)) {
        b(a(2131691665));
      }
      bphr.a().a(str1, new bpho(this, paramAEEditorFilterBean, paramInt));
      return;
    }
    b(paramInt, paramAEEditorFilterBean);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = bpan.a();
    View localView = View.inflate(paramContext, 2131558548, this);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localView.findViewById(2131366664));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new bphl(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362857));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131366663));
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
    return this.jdField_a_of_type_Bphy.a();
  }
  
  public AEEditorFilterBean a()
  {
    return this.c;
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
    this.jdField_a_of_type_Bphy = new bphy(this.jdField_a_of_type_JavaUtilList, 0, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bphy);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bphy.a(paramInt);
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(String paramString)
  {
    bpam.b(jdField_a_of_type_JavaLangString, "selectFilter---" + paramString);
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
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localButton.setVisibility(i);
      return;
    }
  }
  
  public boolean a()
  {
    return a() == 1;
  }
  
  public boolean a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramAEEditorFilterBean;
    if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.AIFilter)
    {
      bpam.b(jdField_a_of_type_JavaLangString, "select ai filter");
      if (this.jdField_a_of_type_Bphp != null)
      {
        this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Bphp.f();
        bozr.a().b(paramAEEditorFilterBean.getEffectId());
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Bphx != null) {
          bool = this.jdField_a_of_type_Bphx.a(this.jdField_b_of_type_Int, paramInt);
        }
        if ((bool) && (this.jdField_a_of_type_Bphp != null)) {
          this.jdField_a_of_type_Bphp.u();
        }
        this.jdField_b_of_type_Int = paramInt;
      }
      return this.jdField_b_of_type_Boolean;
      if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NON)
      {
        bpam.b(jdField_a_of_type_JavaLangString, "select none filter");
        if (this.jdField_a_of_type_Bphp != null)
        {
          this.jdField_a_of_type_Bphp.r();
          bozr.a().b(paramAEEditorFilterBean.getEffectId());
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.CLIENT)
      {
        bpam.b(jdField_a_of_type_JavaLangString, "select color filter: " + paramAEEditorFilterBean.getEffectId());
        String str = bphr.a().b(paramAEEditorFilterBean);
        this.jdField_b_of_type_Boolean = false;
        if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
        {
          a(str, paramInt, paramAEEditorFilterBean);
        }
        else if (!bhnv.a())
        {
          QQToast.a(getContext(), a(2131694006), 0).a();
        }
        else
        {
          if ((paramAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)) {
            b(a(2131691665));
          }
          AEEditorDownloadResBean localAEEditorDownloadResBean = bpdr.a(paramAEEditorFilterBean);
          bphr.a().a(localAEEditorDownloadResBean);
          bphr.a().a(localAEEditorDownloadResBean, new bphm(this, paramAEEditorFilterBean, paramInt, str));
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)
      {
        bpam.b(jdField_a_of_type_JavaLangString, "select comics filter");
        if (this.jdField_a_of_type_Bphp != null)
        {
          this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Bphp.a(paramInt, paramAEEditorFilterBean);
          bozr.a().b(paramAEEditorFilterBean.getEffectId());
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
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
  
  public boolean b()
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
      if ((this.jdField_a_of_type_AndroidWidgetButton.isEnabled()) && (this.jdField_a_of_type_Bphp != null) && ((this.jdField_a_of_type_Bphp instanceof bphq))) {
        ((bphq)this.jdField_a_of_type_Bphp).q();
      }
    }
  }
  
  public void setFilterChangedComparator(bphx parambphx)
  {
    this.jdField_a_of_type_Bphx = parambphx;
  }
  
  public void setFilterControlListener(bphp parambphp)
  {
    this.jdField_a_of_type_Bphp = parambphp;
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
    if (this.jdField_a_of_type_Bphy != null) {
      this.jdField_a_of_type_Bphy.notifyDataSetChanged();
    }
  }
  
  public void setSeekBarValue(float paramFloat)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel
 * JD-Core Version:    0.7.0.1
 */