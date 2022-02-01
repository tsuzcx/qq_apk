package dov.com.qq.im.aeeditor.module.music;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout;
import dov.com.qq.im.aeeditor.util.TimeUtils;
import dov.com.qq.im.aeeditor.view.AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener;
import dov.com.qq.im.aeeditor.view.AEEditorMusicWaveView;
import dov.com.qq.im.aeeditor.view.AEEditorMusicWaveView.IDragIndicatorListener;
import dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView;

public class AEEditorLyricPanelDialog
  extends ReportDialog
  implements View.OnClickListener, AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener, AEEditorMusicWaveView.IDragIndicatorListener
{
  private int jdField_a_of_type_Int;
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final MoreLyricLayout jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout;
  private AEEditorLyricPanelDialog.OperationCallback jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
  private final AEEditorPanelDialogDelegate jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate;
  private final AEEditorMusicWaveView jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView;
  private AEEditorQcircleBubbleView jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private int jdField_b_of_type_Int;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
  public AEEditorLyricPanelDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755056);
    View localView = LayoutInflater.from(paramContext).inflate(2131558572, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131367103));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout = ((MoreLyricLayout)localView.findViewById(2131371792));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380611));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380334));
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView = ((AEEditorMusicWaveView)localView.findViewById(2131362326));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setOnMoreLyricLayoutActionListener(new AEEditorLyricPanelDialog.1(this));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setMoreBackground(paramContext.getResources().getDrawable(2131167305));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setLyricBackgroundEffect(new AEEditorLyricPanelDialog.2(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.setDragIndicatorListener(this);
    localView.findViewById(2131369626).setOnClickListener(this);
    localView.findViewById(2131369595).setOnClickListener(this);
    localView.findViewById(2131380646).setOnClickListener(this);
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_a_of_type_AndroidWidgetTextView, false);
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_b_of_type_AndroidWidgetTextView, false);
    setContentView(localView);
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate = new AEEditorPanelDialogDelegate(this, localView, new AEEditorLyricPanelDialog.3(this));
    c();
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView == null) {}
    while (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a() == this.jdField_a_of_type_Int) {
      return true;
    }
    return false;
  }
  
  private void c()
  {
    if (AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_MUSIC_TAB", true, 0))
    {
      this.jdField_a_of_type_JavaLangRunnable = new AEEditorLyricPanelDialog.6(this);
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.post(new AEEditorLyricPanelDialog.7(this));
    }
  }
  
  private void c(int paramInt)
  {
    int i = this.c;
    b(paramInt);
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setLyricSeek(paramInt);
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.a(paramInt, i + paramInt);
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.L();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.K();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null)
    {
      AEReportUtils.b(9);
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.b(this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a(this.c));
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.a(paramInt1, paramInt2);
    }
  }
  
  public void a(@Nullable AEEditorLyricPanelDialog.OperationCallback paramOperationCallback)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback = paramOperationCallback;
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramAEEditorMusicInfo.a();
    this.jdField_b_of_type_Int = paramAEEditorMusicInfo.b();
    this.c = paramInt2;
    AEEditorLyricProgressCalculator.a().b(paramInt1, Math.min(paramInt1 + paramInt2, this.jdField_b_of_type_Int));
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a(paramAEEditorMusicInfo.a(), AEEditorMusicHelper.a(paramAEEditorMusicInfo), paramAEEditorMusicInfo.b(), paramInt2, false, paramInt3, paramInt4, true, paramBoolean);
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.setOnMusicMoveListener(this);
      b(paramInt1);
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setBackgroundResource(2131167305);
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.a(paramAEEditorMusicInfo, paramInt1, true, false);
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setAlpha(1.0F);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.L();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null) && (!this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.c()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.setIndicatorIndexByVideo(paramInt1, paramInt2);
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.setCurrentPosition(paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.a((int)AEEditorLyricProgressCalculator.a().a(false));
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(TimeUtils.a(TimeUtils.a, paramInt1));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(TimeUtils.a(TimeUtils.a, Math.min(paramInt2, this.jdField_b_of_type_Int)));
    }
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate.c();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369595)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.M();
      }
      dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131369626)
      {
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback != null) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.N();
        }
        dismiss();
      }
      else if ((i == 2131380646) && (!a()) && (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback != null))
      {
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.c(this.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate.a();
    setOnShowListener(new AEEditorLyricPanelDialog.4(this));
    setOnDismissListener(new AEEditorLyricPanelDialog.5(this));
  }
  
  public void show()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorLyricPanelDialog
 * JD-Core Version:    0.7.0.1
 */