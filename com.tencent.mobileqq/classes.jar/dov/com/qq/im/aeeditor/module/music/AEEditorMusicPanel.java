package dov.com.qq.im.aeeditor.module.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AEEditorMusicPanel
  extends FrameLayout
  implements View.OnClickListener, AEEditorMusicAdapter.ClickCallback
{
  private float jdField_a_of_type_Float = 0.8F;
  private int jdField_a_of_type_Int = 1;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final CheckedTextView jdField_a_of_type_AndroidWidgetCheckedTextView;
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEEditorMusicAdapter jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter;
  private AEEditorMusicPanel.OperationCallback jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
  private boolean jdField_a_of_type_Boolean = true;
  private final CheckedTextView jdField_b_of_type_AndroidWidgetCheckedTextView;
  private final LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private final CheckedTextView jdField_c_of_type_AndroidWidgetCheckedTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private final CheckedTextView jdField_d_of_type_AndroidWidgetCheckedTextView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  
  public AEEditorMusicPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2131558573, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131370628));
    this.jdField_a_of_type_AndroidWidgetCheckedTextView = ((CheckedTextView)localView.findViewById(2131365486));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380468));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131370629));
    this.jdField_b_of_type_AndroidWidgetCheckedTextView = ((CheckedTextView)localView.findViewById(2131365487));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380469));
    this.jdField_c_of_type_AndroidWidgetCheckedTextView = ((CheckedTextView)localView.findViewById(2131365490));
    this.jdField_d_of_type_AndroidWidgetCheckedTextView = ((CheckedTextView)localView.findViewById(2131365489));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131377427));
    localView.findViewById(2131370630).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    b(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter = new AEEditorMusicAdapter(paramContext, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter);
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.a(AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_JavaUtilList);
    f();
  }
  
  private int a(int paramInt)
  {
    int m = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.getItemCount();
    int k;
    if (paramInt < 0) {
      k = 0;
    }
    do
    {
      return k;
      k = paramInt;
    } while (paramInt <= m - 1);
    return m - 1;
  }
  
  private void a(boolean paramBoolean)
  {
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.a();
    if (paramBoolean)
    {
      if (!localList.contains(AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo)) {
        localList.add(1, AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      }
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.a(localList);
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.notifyDataSetChanged();
      return;
      localList.remove(AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
    }
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter == null)) {}
    while (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.getItemCount() == 0) {
      return false;
    }
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetCheckedTextView.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetCheckedTextView.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
  }
  
  private void f()
  {
    AEEditorMusicPanel.1 local1 = new AEEditorMusicPanel.1(this);
    this.jdField_c_of_type_AndroidWidgetCheckedTextView.setOnClickListener(local1);
    this.jdField_d_of_type_AndroidWidgetCheckedTextView.setOnClickListener(local1);
  }
  
  private void g()
  {
    c(true);
    this.jdField_b_of_type_AndroidWidgetCheckedTextView.setChecked(true);
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback.k(true);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void h()
  {
    c(true);
    this.jdField_b_of_type_AndroidWidgetCheckedTextView.setChecked(false);
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback.k(false);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void i()
  {
    c(false);
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback.k(false);
    }
  }
  
  @NonNull
  public List<AEEditorMusicAdapter.AEEditorMusicInfo> a()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter != null) {
      return this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.a();
    }
    return new LinkedList();
  }
  
  public void a()
  {
    c();
  }
  
  public void a(float paramFloat)
  {
    if ((!this.jdField_c_of_type_AndroidWidgetCheckedTextView.isChecked()) && (paramFloat > 0.0F))
    {
      this.jdField_c_of_type_AndroidWidgetCheckedTextView.setChecked(true);
      this.jdField_d_of_type_AndroidWidgetCheckedTextView.setChecked(true);
    }
    while ((!this.jdField_c_of_type_AndroidWidgetCheckedTextView.isChecked()) || (paramFloat != 0.0F)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetCheckedTextView.setChecked(false);
    this.jdField_d_of_type_AndroidWidgetCheckedTextView.setChecked(false);
  }
  
  public void a(int paramInt)
  {
    if (!a()) {
      return;
    }
    paramInt = a(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.scrollToPosition(paramInt);
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    a(paramAEEditorMusicInfo, 1, true, 2);
  }
  
  public void a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 1) {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback.F();
      }
    }
    do
    {
      return;
      if (!paramBoolean)
      {
        setEnableBgm(false);
        this.jdField_b_of_type_Boolean = true;
        i();
        return;
      }
      this.h = true;
    } while (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback == null);
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback.a(paramAEEditorMusicInfo, paramInt1);
  }
  
  public void a(@NonNull List<AEEditorMusicAdapter.AEEditorMusicInfo> paramList)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.a(paramList);
    }
    if ((!CollectionUtils.isEmpty(paramList)) && (!this.g))
    {
      this.g = true;
      if (!this.e) {
        setEnableBgm(true);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_d_of_type_Boolean) {}
    while (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback.J();
  }
  
  public void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void c()
  {
    if (this.e)
    {
      this.e = false;
      if (this.g) {
        setEnableBgm(true);
      }
      if (!this.jdField_b_of_type_Boolean) {
        if (this.jdField_a_of_type_Int == 1) {
          h();
        }
      }
    }
    while (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter == null)
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 0);
      h();
      g();
      return;
      i();
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 1;
      h();
      AEBaseReportParam.a().a().g = 0;
    }
    for (;;)
    {
      AEBaseDataReporter.a().n();
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_Int = 0;
        g();
        AEBaseReportParam.a().a().g = 1;
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.b();
    }
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == 2131370630)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback.I();
      }
      AEReportUtils.b(5);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (k == 2131370629)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          d();
          AEReportUtils.b(10);
        }
      }
      else if (k == 2131370628)
      {
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback != null) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback.j(this.i);
        }
        AEReportUtils.b(8);
      }
    }
  }
  
  public void setAutoTemplate(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    CheckedTextView localCheckedTextView = this.jdField_c_of_type_AndroidWidgetCheckedTextView;
    if (!paramBoolean1)
    {
      bool1 = true;
      localCheckedTextView.setChecked(bool1);
      localCheckedTextView = this.jdField_d_of_type_AndroidWidgetCheckedTextView;
      if (paramBoolean1) {
        break label76;
      }
    }
    label76:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckedTextView.setChecked(bool1);
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter.c();
        b(false);
        c(false);
      }
      a(paramBoolean2);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void setBgmPlayed(boolean paramBoolean, AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    this.i = paramBoolean;
    if (this.j) {
      this.j = false;
    }
    if ((!paramBoolean) || ((paramAEEditorMusicInfo != null) && (paramAEEditorMusicInfo.b == 3)))
    {
      b(false);
      this.jdField_b_of_type_Boolean = true;
      i();
      return;
    }
    b(true);
    if (this.jdField_a_of_type_Int == 1) {
      h();
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        h();
        g();
      }
    }
  }
  
  public void setEnableBgm(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback.h(this.h);
    }
  }
  
  public void setOperationCallback(@Nullable AEEditorMusicPanel.OperationCallback paramOperationCallback)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicPanel$OperationCallback = paramOperationCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanel
 * JD-Core Version:    0.7.0.1
 */