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
import blen;
import blfg;
import bljd;
import blje;
import bljf;
import bljg;
import bljh;
import bljn;
import bljo;
import bljq;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AEEditorFilterControlPanel
  extends FrameLayout
  implements View.OnClickListener, bljq
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorFilterControlPanel.class.getSimpleName();
  private int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bljf jdField_a_of_type_Bljf;
  private bljn jdField_a_of_type_Bljn;
  private bljo jdField_a_of_type_Bljo;
  private AEEditorFilterBean jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean = AEEditorFilterBean.createAiFilterInstance();
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AEEditorFilterBean b = AEEditorFilterBean.createNonFilterInstance();
  
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
  
  private void a(Context paramContext)
  {
    View localView = View.inflate(paramContext, 2131558530, this);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localView.findViewById(2131366361));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new bljd(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362728));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131366360));
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559438);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371874);
    if (!TextUtils.isEmpty(paramString)) {
      localTextView.setText(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      localTextView.setText(2131695287);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bljo.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(this.b);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
    this.jdField_a_of_type_Bljo = new bljo(this.jdField_a_of_type_JavaUtilList, 0, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bljo);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
    this.jdField_a_of_type_Bljo.a(paramInt);
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
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
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.AIFilter)
    {
      blfg.b(jdField_a_of_type_JavaLangString, "select ai filter");
      if (this.jdField_a_of_type_Bljf == null) {
        break label302;
      }
      bool1 = this.jdField_a_of_type_Bljf.c();
      blen.a().b(paramAEEditorFilterBean.getSid());
    }
    for (;;)
    {
      if (bool1)
      {
        if (this.jdField_a_of_type_Bljn != null) {
          bool2 = this.jdField_a_of_type_Bljn.a(this.jdField_a_of_type_Int, paramInt);
        }
        if ((bool2) && (this.jdField_a_of_type_Bljf != null)) {
          this.jdField_a_of_type_Bljf.m();
        }
        this.jdField_a_of_type_Int = paramInt;
      }
      return bool1;
      if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NON)
      {
        blfg.b(jdField_a_of_type_JavaLangString, "select none filter");
        if (this.jdField_a_of_type_Bljf != null)
        {
          this.jdField_a_of_type_Bljf.j();
          blen.a().b(paramAEEditorFilterBean.getSid());
          bool1 = true;
        }
      }
      else
      {
        blfg.b(jdField_a_of_type_JavaLangString, "select color filter: " + paramAEEditorFilterBean.getLutName());
        String str = bljh.a().a(paramAEEditorFilterBean);
        if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
        {
          if (this.jdField_a_of_type_Bljf != null)
          {
            this.jdField_a_of_type_Bljf.a(paramInt, str, paramAEEditorFilterBean.getDefaultAlpha(), paramAEEditorFilterBean);
            blen.a().b(paramAEEditorFilterBean.getSid());
            bool1 = true;
          }
        }
        else
        {
          QQToast.a(getContext(), "资源下载中，请稍后再试", 0).a();
          a("资源下载中");
          bljh.a().a(paramAEEditorFilterBean.getSid(), new blje(this, paramInt, str, paramAEEditorFilterBean));
          continue;
        }
      }
      label302:
      bool1 = true;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
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
    do
    {
      return;
    } while ((!this.jdField_a_of_type_AndroidWidgetButton.isEnabled()) || (this.jdField_a_of_type_Bljf == null) || (!(this.jdField_a_of_type_Bljf instanceof bljg)));
    ((bljg)this.jdField_a_of_type_Bljf).i();
  }
  
  public void setFilterChangedComparator(bljn parambljn)
  {
    this.jdField_a_of_type_Bljn = parambljn;
  }
  
  public void setFilterControlListener(bljf parambljf)
  {
    this.jdField_a_of_type_Bljf = parambljf;
  }
  
  public void setFiltersData(List<AEEditorFilterBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.b);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    if (this.jdField_a_of_type_Bljo != null) {
      this.jdField_a_of_type_Bljo.notifyDataSetChanged();
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