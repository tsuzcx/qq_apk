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
import bliu;
import bljn;
import blnp;
import blnq;
import blnr;
import blns;
import blnt;
import blnz;
import bloa;
import bloc;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AEEditorFilterControlPanel
  extends FrameLayout
  implements View.OnClickListener, bloc
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorFilterControlPanel.class.getSimpleName();
  private int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blnr jdField_a_of_type_Blnr;
  private blnz jdField_a_of_type_Blnz;
  private bloa jdField_a_of_type_Bloa;
  private AEEditorFilterBean jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean = AEEditorFilterBean.createAiFilterInstance();
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AEEditorFilterBean b = AEEditorFilterBean.createNonFilterInstance();
  private AEEditorFilterBean c = AEEditorFilterBean.createComicsFilterInstance();
  
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
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void a(Context paramContext)
  {
    View localView = View.inflate(paramContext, 2131558530, this);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localView.findViewById(2131366363));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new blnp(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362728));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131366362));
    paramContext = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(getContext(), 2131755801);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559437);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371894);
    if (!TextUtils.isEmpty(paramString)) {
      localTextView.setText(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      localTextView.setText(2131695289);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bloa.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
    this.jdField_a_of_type_Bloa.a(paramInt);
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(this.b);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.add(this.c);
    }
    this.jdField_a_of_type_Bloa = new bloa(this.jdField_a_of_type_JavaUtilList, 0, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bloa);
  }
  
  public boolean a()
  {
    return a() == 1;
  }
  
  public boolean a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.AIFilter)
    {
      bljn.b(jdField_a_of_type_JavaLangString, "select ai filter");
      if (this.jdField_a_of_type_Blnr == null) {
        break label361;
      }
      bool1 = this.jdField_a_of_type_Blnr.e();
      bliu.a().b(paramAEEditorFilterBean.getSid());
    }
    for (;;)
    {
      if (bool1)
      {
        if (this.jdField_a_of_type_Blnz != null) {
          bool2 = this.jdField_a_of_type_Blnz.a(this.jdField_a_of_type_Int, paramInt);
        }
        if ((bool2) && (this.jdField_a_of_type_Blnr != null)) {
          this.jdField_a_of_type_Blnr.p();
        }
        this.jdField_a_of_type_Int = paramInt;
      }
      return bool1;
      if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NON)
      {
        bljn.b(jdField_a_of_type_JavaLangString, "select none filter");
        if (this.jdField_a_of_type_Blnr != null)
        {
          this.jdField_a_of_type_Blnr.m();
          bliu.a().b(paramAEEditorFilterBean.getSid());
          bool1 = true;
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.COLOR)
      {
        bljn.b(jdField_a_of_type_JavaLangString, "select color filter: " + paramAEEditorFilterBean.getLutName());
        String str = blnt.a().a(paramAEEditorFilterBean);
        if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
        {
          if (this.jdField_a_of_type_Blnr != null)
          {
            this.jdField_a_of_type_Blnr.a(paramInt, str, paramAEEditorFilterBean.getDefaultAlpha(), paramAEEditorFilterBean);
            bliu.a().b(paramAEEditorFilterBean.getSid());
            bool1 = true;
          }
        }
        else
        {
          QQToast.a(getContext(), "资源下载中，请稍后再试", 0).a();
          a("资源下载中");
          blnt.a().a(paramAEEditorFilterBean.getSid(), new blnq(this, paramInt, str, paramAEEditorFilterBean));
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.Comics)
      {
        bljn.b(jdField_a_of_type_JavaLangString, "select comics filter");
        if (this.jdField_a_of_type_Blnr != null)
        {
          bool1 = this.jdField_a_of_type_Blnr.f();
          bliu.a().b(paramAEEditorFilterBean.getSid());
          continue;
        }
      }
      label361:
      bool1 = true;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localButton.setVisibility(i);
      return;
    }
  }
  
  public boolean b()
  {
    return a() == 0;
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
    return a() == 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while ((!this.jdField_a_of_type_AndroidWidgetButton.isEnabled()) || (this.jdField_a_of_type_Blnr == null) || (!(this.jdField_a_of_type_Blnr instanceof blns)));
    ((blns)this.jdField_a_of_type_Blnr).l();
  }
  
  public void setFilterChangedComparator(blnz paramblnz)
  {
    this.jdField_a_of_type_Blnz = paramblnz;
  }
  
  public void setFilterControlListener(blnr paramblnr)
  {
    this.jdField_a_of_type_Blnr = paramblnr;
  }
  
  public void setFiltersData(List<AEEditorFilterBean> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.b);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilList.add(this.c);
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    if (this.jdField_a_of_type_Bloa != null) {
      this.jdField_a_of_type_Bloa.notifyDataSetChanged();
    }
  }
  
  public void setSeekBarValue(float paramFloat)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel
 * JD-Core Version:    0.7.0.1
 */