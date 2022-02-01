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
  private SoundCheckRunnable a;
  private boolean b = false;
  private boolean c = false;
  private Context d;
  private IReadInJoyModel e;
  
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
    SoundCheckRunnable localSoundCheckRunnable = this.a;
    if ((localSoundCheckRunnable == null) || (!localSoundCheckRunnable.b()))
    {
      this.a = new SoundCheckRunnable();
      this.a.a(this);
      ThreadManager.excute(this.a, 16, null, true);
      ThreadManager.getUIHandler().removeCallbacksAndMessages(null);
      ThreadManager.getUIHandler().postDelayed(new NoteCardProteusItem.5(this), 60000L);
    }
  }
  
  private void a(Activity paramActivity)
  {
    try
    {
      new PermissionPageUtil(this.d, this.d.getPackageName()).a();
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
    SoundCheckRunnable localSoundCheckRunnable = this.a;
    if (localSoundCheckRunnable != null)
    {
      localSoundCheckRunnable.a();
      this.a.a(null);
      this.a = null;
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
          int j = localScripCmsInfo.j;
          paramInt = 0;
          int i = 0;
          if ((j != 1) && ((!TextUtils.isEmpty(localScripCmsInfo.g)) || (!TextUtils.isEmpty(localScripCmsInfo.h))))
          {
            localJSONObject.put("main_title_rich", localScripCmsInfo.g.replace("#$%", ReadInJoyNoteCardUtil.b()));
            paramAbsBaseArticleInfo = BaseApplicationImpl.getContext();
            if ((Build.VERSION.SDK_INT < 23) || (paramAbsBaseArticleInfo == null)) {
              break label412;
            }
            paramInt = i;
            if (paramAbsBaseArticleInfo.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
              break label412;
            }
            if ((paramInt == 0) && (ReadInJoyNoteCardUtil.a() == 1)) {
              paramAbsBaseArticleInfo = localScripCmsInfo.h.replace("#$%", paramAbsBaseArticleInfo.getString(2131915458));
            } else {
              paramAbsBaseArticleInfo = localScripCmsInfo.h.replace("#$%", ReadInJoyNoteCardUtil.c());
            }
            localJSONObject.put("sub_title_rich", paramAbsBaseArticleInfo);
            localJSONObject.put("bg_image_url", localScripCmsInfo.i);
            return localJSONObject;
          }
          paramAbsBaseArticleInfo = new JSONObject(localScripCmsInfo.a).getJSONArray("S");
          Object localObject = new JSONObject(localScripCmsInfo.b).getJSONArray("S");
          localJSONObject.put("main_title_rich", a(paramAbsBaseArticleInfo));
          localJSONObject.put("sub_title_rich", a((JSONArray)localObject));
          localJSONObject.put("privacy_text", localScripCmsInfo.d);
          paramAbsBaseArticleInfo = ReadInJoyNoteCardUtil.d();
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
            localJSONObject.put("tips_text", ((Context)localObject).getString(2131915459));
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
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.u() != null))
    {
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)paramIReadInJoyModel.u();
      this.d = paramContainer.getContext();
      this.e = paramIReadInJoyModel;
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
    if (this.d != null)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (ReadInJoyNoteCardUtil.a(this.d, (String)localObject) < ScripCmsInfo.o)
      {
        localObject = this.e;
        if (localObject != null) {
          ((ReadInJoyBaseAdapter)((IReadInJoyModel)localObject).u()).T();
        }
      }
      else
      {
        localObject = this.d;
        QQToast.makeText((Context)localObject, 0, ((Context)localObject).getString(2131915546), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.NoteCardProteusItem
 * JD-Core Version:    0.7.0.1
 */