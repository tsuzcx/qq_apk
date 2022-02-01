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
import bmbc;
import bmbx;
import bmby;
import bmfb;
import bmkh;
import bmki;
import bmkj;
import bmkk;
import bmkl;
import bmkm;
import bmkn;
import bmkt;
import bmku;
import bmkx;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  implements View.OnClickListener, bmkx
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorFilterControlPanel.class.getSimpleName();
  private int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmkl jdField_a_of_type_Bmkl;
  private bmkt jdField_a_of_type_Bmkt;
  private bmku jdField_a_of_type_Bmku;
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
      paramString = (AEFilterExtendBean)new Gson().fromJson(paramString, new bmkj(this).getType());
      return paramString;
    }
    catch (JsonSyntaxException paramString)
    {
      bmbx.d(jdField_a_of_type_JavaLangString, "parse effect json exception: " + paramString.toString());
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
      String str2 = bmkn.a().a(paramAEEditorFilterBean);
      if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
      {
        b(paramInt, paramAEEditorFilterBean);
        return;
      }
      if (!NetworkUtil.isNetworkAvailable())
      {
        QQToast.a(getContext(), a(2131694106), 0).a();
        return;
      }
      if ((paramAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)) {
        b(a(2131691709));
      }
      bmkn.a().a(str1, new bmkk(this, paramAEEditorFilterBean, paramInt));
      return;
    }
    b(paramInt, paramAEEditorFilterBean);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = bmby.a();
    View localView = View.inflate(paramContext, 2131558547, this);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localView.findViewById(2131366691));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new bmkh(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362868));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131366690));
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
    return this.jdField_a_of_type_Bmku.a();
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
    this.jdField_a_of_type_Bmku = new bmku(this.jdField_a_of_type_JavaUtilList, 0, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bmku);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bmku.a(paramInt);
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(String paramString)
  {
    bmbx.b(jdField_a_of_type_JavaLangString, "selectFilter---" + paramString);
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
      bmbx.b(jdField_a_of_type_JavaLangString, "select ai filter");
      if (this.jdField_a_of_type_Bmkl != null)
      {
        this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Bmkl.f();
        bmbc.a().b(paramAEEditorFilterBean.getEffectId());
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Bmkt != null) {
          bool = this.jdField_a_of_type_Bmkt.a(this.jdField_b_of_type_Int, paramInt);
        }
        if ((bool) && (this.jdField_a_of_type_Bmkl != null)) {
          this.jdField_a_of_type_Bmkl.w();
        }
        this.jdField_b_of_type_Int = paramInt;
      }
      return this.jdField_b_of_type_Boolean;
      if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NON)
      {
        bmbx.b(jdField_a_of_type_JavaLangString, "select none filter");
        if (this.jdField_a_of_type_Bmkl != null)
        {
          this.jdField_a_of_type_Bmkl.t();
          bmbc.a().b(paramAEEditorFilterBean.getEffectId());
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.CLIENT)
      {
        bmbx.b(jdField_a_of_type_JavaLangString, "select color filter: " + paramAEEditorFilterBean.getEffectId());
        String str = bmkn.a().b(paramAEEditorFilterBean);
        this.jdField_b_of_type_Boolean = false;
        if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
        {
          a(str, paramInt, paramAEEditorFilterBean);
        }
        else if (!NetworkUtil.isNetworkAvailable())
        {
          QQToast.a(getContext(), a(2131694106), 0).a();
        }
        else
        {
          if ((paramAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)) {
            b(a(2131691709));
          }
          AEEditorDownloadResBean localAEEditorDownloadResBean = bmfb.a(paramAEEditorFilterBean);
          bmkn.a().a(localAEEditorDownloadResBean);
          bmkn.a().a(localAEEditorDownloadResBean, new bmki(this, paramAEEditorFilterBean, paramInt, str));
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)
      {
        bmbx.b(jdField_a_of_type_JavaLangString, "select comics filter");
        if (this.jdField_a_of_type_Bmkl != null)
        {
          this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Bmkl.a(paramInt, paramAEEditorFilterBean);
          bmbc.a().b(paramAEEditorFilterBean.getEffectId());
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
      if ((this.jdField_a_of_type_AndroidWidgetButton.isEnabled()) && (this.jdField_a_of_type_Bmkl != null) && ((this.jdField_a_of_type_Bmkl instanceof bmkm))) {
        ((bmkm)this.jdField_a_of_type_Bmkl).s();
      }
    }
  }
  
  public void setFilterChangedComparator(bmkt parambmkt)
  {
    this.jdField_a_of_type_Bmkt = parambmkt;
  }
  
  public void setFilterControlListener(bmkl parambmkl)
  {
    this.jdField_a_of_type_Bmkl = parambmkl;
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
    if (this.jdField_a_of_type_Bmku != null) {
      this.jdField_a_of_type_Bmku.notifyDataSetChanged();
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