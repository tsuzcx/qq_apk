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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class pww
  implements psa, pye
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SoundCheckRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable;
  private ppu jdField_a_of_type_Ppu;
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
      new azoy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getPackageName()).a();
      mvd.a(paramActivity);
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
  
  public void A_()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (prz.a(this.jdField_a_of_type_AndroidContentContext, str) >= qxc.jdField_d_of_type_Int) {
        break label51;
      }
      if (this.jdField_a_of_type_Ppu != null) {
        this.jdField_a_of_type_Ppu.a().o();
      }
    }
    return;
    label51:
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, this.jdField_a_of_type_AndroidContentContext.getString(2131717314), 0).a();
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
      qxc localqxc;
      try
      {
        localqxc = paramBaseArticleInfo.scripCmsInfo;
        if (localqxc == null) {
          break;
        }
        if ((localqxc.jdField_a_of_type_Int == 1) || ((TextUtils.isEmpty(localqxc.g)) && (TextUtils.isEmpty(localqxc.h))))
        {
          paramBaseArticleInfo = new JSONObject(localqxc.jdField_a_of_type_JavaLangString).getJSONArray("S");
          Object localObject = new JSONObject(localqxc.b).getJSONArray("S");
          localJSONObject.put("main_title_rich", a(paramBaseArticleInfo));
          localJSONObject.put("sub_title_rich", a((JSONArray)localObject));
          localJSONObject.put("privacy_text", localqxc.jdField_d_of_type_JavaLangString);
          paramBaseArticleInfo = prz.c();
          localObject = BaseApplicationImpl.getContext();
          if ((Build.VERSION.SDK_INT < 23) || (localObject == null)) {
            break label415;
          }
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            paramInt = 1;
          }
          if ((paramInt == 0) && (prz.a() == 1))
          {
            localJSONObject.put("tips_text", ((Context)localObject).getString(2131717212));
            localJSONObject.put("icon_image_url", localqxc.e);
            localJSONObject.put("bg_image_url", localqxc.c);
            localJSONObject.put("animation_url", localqxc.f);
            return localJSONObject;
          }
          localJSONObject.put("tips_text", paramBaseArticleInfo);
          continue;
        }
        localJSONObject.put("main_title_rich", localqxc.g.replace("#$%", prz.a()));
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
        if ((paramInt == 0) && (prz.a() == 1)) {}
        for (paramBaseArticleInfo = localqxc.h.replace("#$%", paramBaseArticleInfo.getString(2131717211));; paramBaseArticleInfo = localqxc.h.replace("#$%", prz.b()))
        {
          localJSONObject.put("sub_title_rich", paramBaseArticleInfo);
          localJSONObject.put("bg_image_url", localqxc.i);
          return localJSONObject;
        }
      }
      label415:
      paramInt = 1;
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    sel localsel;
    if ((paramppu != null) && (paramppu.a() != null))
    {
      localsel = paramppu.a();
      this.jdField_a_of_type_AndroidContentContext = paramContainer.getContext();
      this.jdField_a_of_type_Ppu = paramppu;
      localObject = paramContainer.getViewIdMapping();
      if ((((Map)localObject).get("id_lottie_view") == null) || (!(((Map)localObject).get("id_lottie_view") instanceof qby))) {
        break label102;
      }
    }
    label102:
    for (Object localObject = (qby)((Map)localObject).get("id_lottie_view");; localObject = null)
    {
      localsel.a(new pwx(this, (qby)localObject, paramppu, paramContainer));
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    case 1165: 
      paramViewBase.setOnClickListener(new pwy(this, paramppu, paramContainer));
      return true;
    case 1166: 
      paramViewBase.setOnClickListener(new pwz(this, paramContainer));
      return true;
    }
    paramViewBase.setOnClickListener(new pxa(this, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pww
 * JD-Core Version:    0.7.0.1
 */