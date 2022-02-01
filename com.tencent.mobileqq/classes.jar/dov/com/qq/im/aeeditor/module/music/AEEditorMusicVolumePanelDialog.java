package dov.com.qq.im.aeeditor.module.music;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class AEEditorMusicVolumePanelDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final View jdField_a_of_type_AndroidViewView;
  private final SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private AEEditorMusicVolumePanelDialog.OperationCallback jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback;
  private final AEEditorPanelDialogDelegate jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate;
  private int jdField_b_of_type_Int;
  private final View jdField_b_of_type_AndroidViewView;
  private final SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  private int c = 50;
  
  public AEEditorMusicVolumePanelDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755056);
    paramContext = LayoutInflater.from(paramContext).inflate(2131558574, null);
    paramContext.findViewById(2131369595).setOnClickListener(this);
    paramContext.findViewById(2131369626).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131372052);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramContext.findViewById(2131372051));
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2131372618);
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)paramContext.findViewById(2131372617));
    setContentView(paramContext);
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate = new AEEditorPanelDialogDelegate(this, paramContext, new AEEditorMusicVolumePanelDialog.1(this));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new AEEditorMusicVolumePanelDialog.2(this));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new AEEditorMusicVolumePanelDialog.3(this));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new AEEditorMusicVolumePanelDialog.4(this));
    this.jdField_b_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new AEEditorMusicVolumePanelDialog.5(this));
  }
  
  private void a(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      QQToast.a(getContext(), paramInt, 0).a();
    }
  }
  
  public void a(@Nullable AEEditorMusicVolumePanelDialog.OperationCallback paramOperationCallback)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback = paramOperationCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(50);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_Int = 50;
      this.jdField_b_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(50);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(50);
    this.jdField_a_of_type_Int = 50;
    this.jdField_b_of_type_Int = 50;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_b_of_type_Int = 0;
      return;
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(this.c);
    this.jdField_b_of_type_Int = this.c;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(paramBoolean);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(paramBoolean);
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate.c();
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback.H();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369595)
    {
      dismiss();
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131369626)
      {
        dismiss();
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
        this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidWidgetSeekBar.getProgress();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate.a();
  }
  
  public void show()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate.b();
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback.G();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicVolumePanelDialog
 * JD-Core Version:    0.7.0.1
 */