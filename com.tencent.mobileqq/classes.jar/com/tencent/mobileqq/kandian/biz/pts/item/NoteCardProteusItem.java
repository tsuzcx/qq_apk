package com.tencent.mobileqq.kandian.biz.pts.item;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.notecard.ReadInJoyNoteCardUtil;
import com.tencent.mobileqq.kandian.biz.notecard.SoundCheckRunnable;
import com.tencent.mobileqq.kandian.biz.notecard.SoundCheckRunnable.OnSoundActionListener;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLottieView;
import com.tencent.mobileqq.kandian.repo.feeds.ScripCmsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.phonecontact.PermissionPageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class NoteCardProteusItem
  implements SoundCheckRunnable.OnSoundActionListener, ProteusItem
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SoundCheckRunnable jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  private SpannableStringBuilder a(JSONArray paramJSONArray)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = new JSONObject(paramJSONArray.get(i).toString());
      String str = ((JSONObject)localObject).optString("word", "    ");
      int j = Color.parseColor(((JSONObject)localObject).optString("color", "#C3C0D6"));
      int k = Integer.valueOf(((JSONObject)localObject).optString("size", "15")).intValue();
      localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(j), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(k, true), 0, str.length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject);
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private void a()
  {
    SoundCheckRunnable localSoundCheckRunnable = this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable;
    if ((localSoundCheckRunnable == null) || (!localSoundCheckRunnable.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable = new SoundCheckRunnable();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable.a(this);
      ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable, 16, null, true);
      ThreadManager.getUIHandler().removeCallbacksAndMessages(null);
      ThreadManager.getUIHandler().postDelayed(new NoteCardProteusItem.5(this), 60000L);
    }
  }
  
  private void a(Activity paramActivity)
  {
    try
    {
      new PermissionPageUtil(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getPackageName()).a();
      UITools.a(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NoteCardProteusItem", 1, paramActivity, new Object[0]);
      }
    }
  }
  
  private void b()
  {
    SoundCheckRunnable localSoundCheckRunnable = this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable;
    if (localSoundCheckRunnable != null)
    {
      localSoundCheckRunnable.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable.a(null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable = null;
    }
    ThreadManager.getUIHandler().removeCallbacksAndMessages(null);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInjoy_zhitiao_view");
    for (;;)
    {
      try
      {
        ScripCmsInfo localScripCmsInfo = paramAbsBaseArticleInfo.scripCmsInfo;
        if (localScripCmsInfo != null)
        {
          int j = localScripCmsInfo.jdField_a_of_type_Int;
          paramInt = 0;
          int i = 0;
          if ((j != 1) && ((!TextUtils.isEmpty(localScripCmsInfo.g)) || (!TextUtils.isEmpty(localScripCmsInfo.h))))
          {
            localJSONObject.put("main_title_rich", localScripCmsInfo.g.replace("#$%", ReadInJoyNoteCardUtil.a()));
            paramAbsBaseArticleInfo = BaseApplicationImpl.getContext();
            if ((Build.VERSION.SDK_INT < 23) || (paramAbsBaseArticleInfo == null)) {
              break label412;
            }
            paramInt = i;
            if (paramAbsBaseArticleInfo.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
              break label412;
            }
            if ((paramInt == 0) && (ReadInJoyNoteCardUtil.a() == 1)) {
              paramAbsBaseArticleInfo = localScripCmsInfo.h.replace("#$%", paramAbsBaseArticleInfo.getString(2131717978));
            } else {
              paramAbsBaseArticleInfo = localScripCmsInfo.h.replace("#$%", ReadInJoyNoteCardUtil.b());
            }
            localJSONObject.put("sub_title_rich", paramAbsBaseArticleInfo);
            localJSONObject.put("bg_image_url", localScripCmsInfo.i);
            return localJSONObject;
          }
          paramAbsBaseArticleInfo = new JSONObject(localScripCmsInfo.jdField_a_of_type_JavaLangString).getJSONArray("S");
          Object localObject = new JSONObject(localScripCmsInfo.b).getJSONArray("S");
          localJSONObject.put("main_title_rich", a(paramAbsBaseArticleInfo));
          localJSONObject.put("sub_title_rich", a((JSONArray)localObject));
          localJSONObject.put("privacy_text", localScripCmsInfo.jdField_d_of_type_JavaLangString);
          paramAbsBaseArticleInfo = ReadInJoyNoteCardUtil.c();
          localObject = BaseApplicationImpl.getContext();
          if ((Build.VERSION.SDK_INT >= 23) && (localObject != null))
          {
            i = ((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO");
            if (i != 0) {}
          }
          else
          {
            paramInt = 1;
          }
          if ((paramInt == 0) && (ReadInJoyNoteCardUtil.a() == 1)) {
            localJSONObject.put("tips_text", ((Context)localObject).getString(2131717979));
          } else {
            localJSONObject.put("tips_text", paramAbsBaseArticleInfo);
          }
          localJSONObject.put("icon_image_url", localScripCmsInfo.e);
          localJSONObject.put("bg_image_url", localScripCmsInfo.c);
          localJSONObject.put("animation_url", localScripCmsInfo.f);
          return localJSONObject;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        QLog.d("NoteCardProteusItem", 2, paramAbsBaseArticleInfo.getMessage());
      }
      return localJSONObject;
      label412:
      paramInt = 1;
    }
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.a() != null))
    {
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)paramIReadInJoyModel.a();
      this.jdField_a_of_type_AndroidContentContext = paramContainer.getContext();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
      Object localObject = paramContainer.getViewIdMapping();
      if ((((Map)localObject).get("id_lottie_view") != null) && ((((Map)localObject).get("id_lottie_view") instanceof ReadInJoyLottieView))) {
        localObject = (ReadInJoyLottieView)((Map)localObject).get("id_lottie_view");
      } else {
        localObject = null;
      }
      localReadInJoyBaseAdapter.a(new NoteCardProteusItem.1(this, (ReadInJoyLottieView)localObject, paramIReadInJoyModel, paramContainer));
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    case 1172: 
      paramViewBase.setOnClickListener(new NoteCardProteusItem.4(this, paramContainer));
      return true;
    case 1171: 
      paramViewBase.setOnClickListener(new NoteCardProteusItem.3(this, paramContainer));
      return true;
    }
    paramViewBase.setOnClickListener(new NoteCardProteusItem.2(this, paramIReadInJoyModel, paramContainer));
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (ReadInJoyNoteCardUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject) < ScripCmsInfo.jdField_d_of_type_Int)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
        if (localObject != null) {
          ((ReadInJoyBaseAdapter)((IReadInJoyModel)localObject).a()).i();
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidContentContext;
        QQToast.a((Context)localObject, 0, ((Context)localObject).getString(2131718069), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.NoteCardProteusItem
 * JD-Core Version:    0.7.0.1
 */