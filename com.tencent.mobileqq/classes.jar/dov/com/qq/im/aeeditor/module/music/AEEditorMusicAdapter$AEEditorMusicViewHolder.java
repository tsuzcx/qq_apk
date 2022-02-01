package dov.com.qq.im.aeeditor.module.music;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ApolloLottieAnim;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.aeeditor.AEEditorConstants;

class AEEditorMusicAdapter$AEEditorMusicViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837931);
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim;
  private AEEditorMusicAdapter.AEEditorMusicInfo jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
  private AEEditorMusicAdapter.ClickCallback jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback;
  private final int jdField_b_of_type_Int;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public AEEditorMusicAdapter$AEEditorMusicViewHolder(@NonNull View paramView, @Nullable AEEditorMusicAdapter.ClickCallback paramClickCallback, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376492));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369727));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367083));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369730));
    this.c = ((ImageView)paramView.findViewById(2131369731));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380471));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramView.findViewById(2131365761));
    this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim = new ApolloLottieAnim(null, paramView.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback = paramClickCallback;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    }
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = paramAEEditorMusicInfo;
    this.jdField_a_of_type_Int = paramInt1;
    URLDrawable localURLDrawable;
    if ((paramAEEditorMusicInfo.jdField_b_of_type_Int == 2) && (!TextUtils.isEmpty(paramAEEditorMusicInfo.c())))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_Int > 0)
      {
        localURLDrawable = URLDrawableHelper.getDrawable(paramAEEditorMusicInfo.c(), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        label75:
        if (!paramAEEditorMusicInfo.jdField_a_of_type_Boolean) {
          break label336;
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837929);
        if (paramAEEditorMusicInfo.jdField_a_of_type_Int != 1) {
          break label252;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        label133:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        if (paramAEEditorMusicInfo.jdField_b_of_type_Int != 1) {
          break label617;
        }
        paramAEEditorMusicInfo = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getString(2131689763);
        label178:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAEEditorMusicInfo);
        paramAEEditorMusicInfo = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (paramInt1 != 0) {
          break label707;
        }
        paramAEEditorMusicInfo.leftMargin = ViewUtils.a(12.0F);
        paramAEEditorMusicInfo.rightMargin = (-ViewUtils.a(4.0F));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAEEditorMusicInfo);
      return;
      localURLDrawable = URLDrawableHelper.getDrawable(paramAEEditorMusicInfo.c());
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label75;
      label252:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(AEEditorConstants.b))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, AEEditorConstants.b, true);
        break label133;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, "https://downv6.qq.com/shadow_qqcamera/Android/lottie/MusicWave_8e84b13bfc72dd3c86c70617db423aef.zip", AEEditorConstants.a, true);
      break label133;
      label336:
      if (paramAEEditorMusicInfo.jdField_b_of_type_Int == 0)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837931);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 0);
        break;
        if (paramAEEditorMusicInfo.jdField_b_of_type_Int == 1)
        {
          this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837931);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837961);
          this.c.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        }
        else
        {
          if (paramAEEditorMusicInfo.jdField_b_of_type_Int != 3) {
            break label542;
          }
          this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837931);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.c.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837962);
        }
      }
      label542:
      if (paramAEEditorMusicInfo.jdField_a_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837929);
        this.c.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        break;
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.c.setVisibility(8);
      }
      label617:
      if (paramAEEditorMusicInfo.jdField_b_of_type_Int == 3)
      {
        paramAEEditorMusicInfo = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getString(2131689766);
        break label178;
      }
      if (TextUtils.isEmpty(AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo)))
      {
        paramAEEditorMusicInfo = "";
        break label178;
      }
      if (AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo).length() > 5)
      {
        paramAEEditorMusicInfo = AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo).substring(0, 5) + "...";
        break label178;
      }
      paramAEEditorMusicInfo = AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo);
      break label178;
      label707:
      if (paramInt1 == paramInt2 - 1)
      {
        paramAEEditorMusicInfo.leftMargin = (-ViewUtils.a(4.0F));
        paramAEEditorMusicInfo.rightMargin = ViewUtils.a(12.0F);
      }
      else
      {
        paramAEEditorMusicInfo.leftMargin = (-ViewUtils.a(4.0F));
        paramAEEditorMusicInfo.rightMargin = (-ViewUtils.a(4.0F));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramView.getId() == 2131376492) && (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo != null) && (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_b_of_type_Int == 1) {
        break label107;
      }
      localClickCallback = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback;
      localAEEditorMusicInfo = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      i = getAdapterPosition();
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_a_of_type_Boolean) {
        break label102;
      }
      localClickCallback.a(localAEEditorMusicInfo, i, bool1, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_b_of_type_Int);
    }
    label102:
    label107:
    while (AEFastClickThrottle.a("tag_music_search_btn")) {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bool1 = false;
      }
    }
    AEEditorMusicAdapter.ClickCallback localClickCallback = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback;
    AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
    int i = getAdapterPosition();
    if (!this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_a_of_type_Boolean) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localClickCallback.a(localAEEditorMusicInfo, i, bool1, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_b_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicViewHolder
 * JD-Core Version:    0.7.0.1
 */