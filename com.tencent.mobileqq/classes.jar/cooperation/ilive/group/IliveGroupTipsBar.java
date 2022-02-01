package cooperation.ilive.group;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.ilive.group.entity.IliveGroupTipsEntity;
import cooperation.ilive.share.IliveShareHelper;

public class IliveGroupTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private PatchedButton jdField_a_of_type_ComTencentWidgetPatchedButton;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  private IliveGroupTipsEntity jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  
  public IliveGroupTipsBar(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837913);
    c();
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378971));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378974));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131378972));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378973));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_a_of_type_Int = AIOUtils.b(39.0F, this.jdField_a_of_type_AndroidViewView.getResources());
  }
  
  @TargetApi(19)
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null)
    {
      ((QQBlurView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      ((QQBlurView)localObject).b((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        QLog.d("IliveGroupTipsBar", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals((String)this.jdField_a_of_type_ComTencentWidgetThemeImageView.getTag())))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      int i = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      i = this.jdField_a_of_type_Int;
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(i, i, 6));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.d);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setTag(paramString);
      paramString = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (paramString != null) {
        paramString.setDecodeHandler(null);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372292));
    b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      QLog.d("IliveGroupTipsBar", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131372219);
    if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false)))
    {
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131167028));
      ((View)localObject).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showBlurView() gone called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        QLog.d("IliveGroupTipsBar", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
      return;
    }
    ((View)localObject).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() visibility called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      QLog.d("IliveGroupTipsBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void c(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(paramString);
  }
  
  private void d(String paramString)
  {
    this.b.setText(paramString);
    this.b.setContentDescription(paramString);
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131560933, null);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("bars onAIOEvent eventType = ");
    paramVarArgs.append(paramInt);
    QLog.i("IliveGroupTipsBar", 1, paramVarArgs.toString());
  }
  
  public void a(IliveGroupTipsEntity paramIliveGroupTipsEntity)
  {
    if (paramIliveGroupTipsEntity == null) {
      return;
    }
    this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity = paramIliveGroupTipsEntity;
    b(paramIliveGroupTipsEntity.b);
    c(paramIliveGroupTipsEntity.jdField_a_of_type_JavaLangString);
    d(paramIliveGroupTipsEntity.c);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 29;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity;
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((IliveGroupTipsEntity)localObject1).d;
    }
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      IliveShareHelper.reportAction("qq_live", "live_group_page", "live_group", "group_bar", "4", 102, IliveShareHelper.getFollowInfo("", "", "", "", ""));
      if (URLUtil.isNetworkUrl((String)localObject1))
      {
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
        ((Intent)localObject2).addFlags(268435456);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
      }
      else
      {
        localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1);
        if (localObject1 != null) {
          ((JumpAction)localObject1).a();
        } else if (QLog.isColorLevel()) {
          QLog.d("IliveGroupTipsBar", 2, "onEditorAction jumpUrl is illegal");
        }
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ilvie group bar click null , url = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("IliveGroupTipsBar", 1, ((StringBuilder)localObject2).toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsBar
 * JD-Core Version:    0.7.0.1
 */