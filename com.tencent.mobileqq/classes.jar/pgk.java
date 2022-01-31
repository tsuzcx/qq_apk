import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.NoteCardProteusItem.5;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class pgk
  implements pcf, phs
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SoundCheckRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable;
  private pax jdField_a_of_type_Pax;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
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
  
  private void a(Activity paramActivity)
  {
    try
    {
      new aumh(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getPackageName()).a();
      muf.a(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NoteCardProteusItem", 1, paramActivity, new Object[0]);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable = new SoundCheckRunnable();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a(this);
      ThreadManager.excute(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable, 16, null, true);
      ThreadManager.getUIHandler().removeCallbacksAndMessages(null);
      ThreadManager.getUIHandler().postDelayed(new NoteCardProteusItem.5(this), 60000L);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable = null;
    }
    ThreadManager.getUIHandler().removeCallbacksAndMessages(null);
  }
  
  public void F_()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (pce.a(this.jdField_a_of_type_AndroidContentContext, str) >= qce.jdField_d_of_type_Int) {
        break label51;
      }
      if (this.jdField_a_of_type_Pax != null) {
        this.jdField_a_of_type_Pax.a().o();
      }
    }
    return;
    label51:
    bcpw.a(this.jdField_a_of_type_AndroidContentContext, 0, this.jdField_a_of_type_AndroidContentContext.getString(2131718583), 0).a();
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    int i = 0;
    paramInt = 0;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInjoy_zhitiao_view");
    for (;;)
    {
      qce localqce;
      try
      {
        localqce = paramBaseArticleInfo.scripCmsInfo;
        if (localqce == null) {
          break;
        }
        if ((localqce.jdField_a_of_type_Int == 1) || ((TextUtils.isEmpty(localqce.g)) && (TextUtils.isEmpty(localqce.h))))
        {
          paramBaseArticleInfo = new JSONObject(localqce.jdField_a_of_type_JavaLangString).getJSONArray("S");
          Object localObject = new JSONObject(localqce.b).getJSONArray("S");
          localJSONObject.put("main_title_rich", a(paramBaseArticleInfo));
          localJSONObject.put("sub_title_rich", a((JSONArray)localObject));
          localJSONObject.put("privacy_text", localqce.jdField_d_of_type_JavaLangString);
          paramBaseArticleInfo = pce.c();
          localObject = BaseApplicationImpl.getContext();
          if ((Build.VERSION.SDK_INT < 23) || (localObject == null)) {
            break label415;
          }
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            paramInt = 1;
          }
          if ((paramInt == 0) && (pce.a() == 1))
          {
            localJSONObject.put("tips_text", ((Context)localObject).getString(2131718506));
            localJSONObject.put("icon_image_url", localqce.e);
            localJSONObject.put("bg_image_url", localqce.c);
            localJSONObject.put("animation_url", localqce.f);
            return localJSONObject;
          }
          localJSONObject.put("tips_text", paramBaseArticleInfo);
          continue;
        }
        localJSONObject.put("main_title_rich", localqce.g.replace("#$%", pce.a()));
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("NoteCardProteusItem", 2, paramBaseArticleInfo.getMessage());
        return localJSONObject;
      }
      paramBaseArticleInfo = BaseApplicationImpl.getContext();
      if ((Build.VERSION.SDK_INT >= 23) && (paramBaseArticleInfo != null))
      {
        paramInt = i;
        if (paramBaseArticleInfo.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {}
      }
      for (paramInt = 1;; paramInt = 1)
      {
        if ((paramInt == 0) && (pce.a() == 1)) {}
        for (paramBaseArticleInfo = localqce.h.replace("#$%", paramBaseArticleInfo.getString(2131718505));; paramBaseArticleInfo = localqce.h.replace("#$%", pce.b()))
        {
          localJSONObject.put("sub_title_rich", paramBaseArticleInfo);
          localJSONObject.put("bg_image_url", localqce.i);
          return localJSONObject;
        }
      }
      label415:
      paramInt = 1;
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2)
  {
    rap localrap;
    if ((parampax != null) && (parampax.a() != null))
    {
      localrap = parampax.a();
      this.jdField_a_of_type_AndroidContentContext = paramContainer.getContext();
      this.jdField_a_of_type_Pax = parampax;
      localObject = paramContainer.getViewIdMapping();
      if ((((Map)localObject).get("id_lottie_view") == null) || (!(((Map)localObject).get("id_lottie_view") instanceof pli))) {
        break label102;
      }
    }
    label102:
    for (Object localObject = (pli)((Map)localObject).get("id_lottie_view");; localObject = null)
    {
      localrap.a(new pgl(this, (pli)localObject, parampax, paramContainer));
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    case 1155: 
      paramViewBase.setOnClickListener(new pgm(this, parampax, paramContainer));
      return true;
    case 1156: 
      paramViewBase.setOnClickListener(new pgn(this, paramContainer));
      return true;
    }
    paramViewBase.setOnClickListener(new pgo(this, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgk
 * JD-Core Version:    0.7.0.1
 */