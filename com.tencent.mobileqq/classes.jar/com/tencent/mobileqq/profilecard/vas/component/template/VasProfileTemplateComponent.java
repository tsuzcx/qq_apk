package com.tencent.mobileqq.profilecard.vas.component.template;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ITemplateManager;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoManagerImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.profilecard.IProfileTemplateController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/template/VasProfileTemplateComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileComponent;", "Landroid/view/View;", "Lcom/tencent/mobileqq/profilecard/template/ITemplateManager;", "Lcom/tencent/mobileqq/profilecard/template/ITemplateUtils;", "Lcom/tencent/mobileqq/profilecard/template/IDiyMoreInfoManager;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "mVasProfileTemplateController", "Lcom/tencent/mobileqq/vas/profilecard/IProfileTemplateController;", "deleteOldCardTemplateDir", "", "name", "", "currentVersion", "getComponentName", "getComponentType", "", "getDiyTemplateVersion", "", "card", "Lcom/tencent/mobileqq/data/Card;", "getPhotoWallDiyView", "V", "kotlin.jvm.PlatformType", "p0", "(Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)Landroid/view/View;", "getQZoneDiyView", "T", "(Ljava/lang/String;)Landroid/view/View;", "getTemplateDrawable", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;", "p1", "", "p2", "p3", "initDiyTemplate", "Lcom/tencent/mobileqq/app/QBaseActivity;", "initTemplateConfig", "isDiy", "preNotifyOnCardUpdate", "activity", "updateAccountInfoForDeepDiy", "updateBaseInfoForDeepDiy", "updateItemThemeForDIYTemplate", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "p4", "p5", "updateLevelForDeepDiy", "updateMetalForDeepDiy", "updatePhotoWallForDeepDiy", "updateQzoneForDeepDiy", "updateSignForDeepDiy", "updateTroopMemInfoForDeepDiy", "updateViewAttr", "updateViewAttrForTemplate", "view", "attr", "currentTemplate", "attrKey", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasProfileTemplateComponent
  extends AbsProfileComponent<View>
  implements IDiyMoreInfoManager, ITemplateManager, ITemplateUtils
{
  public static final VasProfileTemplateComponent.Companion Companion = new VasProfileTemplateComponent.Companion(null);
  private static final String TAG = "VasProfileTemplateComponent";
  private IProfileTemplateController mVasProfileTemplateController;
  
  public VasProfileTemplateComponent(@Nullable IComponentCenter paramIComponentCenter, @Nullable ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public void deleteOldCardTemplateDir(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "currentVersion");
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir clear old version template dir");
    }
    Object localObject1 = BaseApplication.getContext().getDir(".profilecard", 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getConte…ME, Context.MODE_PRIVATE)");
    localObject1 = ((File)localObject1).getAbsolutePath();
    try
    {
      File[] arrayOfFile = new File((String)localObject1).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = arrayOfFile[i];
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "childDirList[i]");
          localObject2 = ((File)localObject2).getName();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "dirName");
          if ((StringsKt.startsWith$default((String)localObject2, paramString1, false, 2, null)) && (!StringsKt.endsWith$default((String)localObject2, paramString2, false, 2, null)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(File.separator);
            localStringBuilder.append(paramString1);
            localStringBuilder.append("_");
            localStringBuilder.append((String)localObject2);
            localObject2 = localStringBuilder.toString();
            FileUtils.deleteDirectory((String)localObject2);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("deleteOldCardTemplateDir old dir=");
              localStringBuilder.append((String)localObject2);
              QLog.i("Q.profilecard.FrdProfileCard", 2, localStringBuilder.toString());
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  @NotNull
  public String getComponentName()
  {
    return "VasProfileTemplateComponent";
  }
  
  public int getComponentType()
  {
    return 1034;
  }
  
  /* Error */
  public long getDiyTemplateVersion(@NotNull com.tencent.mobileqq.data.Card paramCard)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 241
    //   3: invokestatic 149	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: getfield 247	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   10: invokestatic 253	com/tencent/mobileqq/profilecard/template/ProfileTemplateApi:isDiyTemplateStyleID	(J)Z
    //   13: istore_2
    //   14: lconst_0
    //   15: lstore 5
    //   17: iload_2
    //   18: ifne +5 -> 23
    //   21: lconst_0
    //   22: lreturn
    //   23: aload_1
    //   24: getfield 256	com/tencent/mobileqq/data/Card:diyComplicatedInfo	Ljava/lang/String;
    //   27: checkcast 258	java/lang/CharSequence
    //   30: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +5 -> 38
    //   36: lconst_0
    //   37: lreturn
    //   38: new 266	android/util/JsonReader
    //   41: dup
    //   42: new 268	java/io/StringReader
    //   45: dup
    //   46: aload_1
    //   47: getfield 256	com/tencent/mobileqq/data/Card:diyComplicatedInfo	Ljava/lang/String;
    //   50: invokespecial 269	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   53: checkcast 271	java/io/Reader
    //   56: invokespecial 274	android/util/JsonReader:<init>	(Ljava/io/Reader;)V
    //   59: checkcast 276	java/io/Closeable
    //   62: astore 8
    //   64: aconst_null
    //   65: checkcast 240	java/lang/Throwable
    //   68: astore 7
    //   70: aload 7
    //   72: astore_1
    //   73: aload 8
    //   75: checkcast 266	android/util/JsonReader
    //   78: astore 9
    //   80: aload 7
    //   82: astore_1
    //   83: aload 9
    //   85: invokevirtual 279	android/util/JsonReader:beginObject	()V
    //   88: lload 5
    //   90: lstore_3
    //   91: aload 7
    //   93: astore_1
    //   94: aload 9
    //   96: invokevirtual 282	android/util/JsonReader:hasNext	()Z
    //   99: ifeq +56 -> 155
    //   102: aload 7
    //   104: astore_1
    //   105: ldc_w 284
    //   108: aload 9
    //   110: invokevirtual 287	android/util/JsonReader:nextName	()Ljava/lang/String;
    //   113: invokestatic 291	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   116: ifeq +15 -> 131
    //   119: aload 7
    //   121: astore_1
    //   122: aload 9
    //   124: invokevirtual 295	android/util/JsonReader:nextLong	()J
    //   127: lstore_3
    //   128: goto +27 -> 155
    //   131: aload 7
    //   133: astore_1
    //   134: aload 9
    //   136: invokevirtual 298	android/util/JsonReader:skipValue	()V
    //   139: goto -51 -> 88
    //   142: astore 9
    //   144: aload 7
    //   146: astore_1
    //   147: aload 9
    //   149: invokevirtual 235	java/lang/Exception:printStackTrace	()V
    //   152: lload 5
    //   154: lstore_3
    //   155: aload 7
    //   157: astore_1
    //   158: getstatic 304	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   161: astore 9
    //   163: aload 8
    //   165: aload 7
    //   167: invokestatic 310	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   170: lload_3
    //   171: lreturn
    //   172: astore 7
    //   174: goto +11 -> 185
    //   177: astore 7
    //   179: aload 7
    //   181: astore_1
    //   182: aload 7
    //   184: athrow
    //   185: aload 8
    //   187: aload_1
    //   188: invokestatic 310	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   191: goto +6 -> 197
    //   194: aload 7
    //   196: athrow
    //   197: goto -3 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	VasProfileTemplateComponent
    //   0	200	1	paramCard	com.tencent.mobileqq.data.Card
    //   13	5	2	bool	boolean
    //   90	81	3	l1	long
    //   15	138	5	l2	long
    //   68	98	7	localThrowable1	java.lang.Throwable
    //   172	1	7	localObject	Object
    //   177	18	7	localThrowable2	java.lang.Throwable
    //   62	124	8	localCloseable	java.io.Closeable
    //   78	57	9	localJsonReader	android.util.JsonReader
    //   142	6	9	localException	Exception
    //   161	1	9	localUnit	kotlin.Unit
    // Exception table:
    //   from	to	target	type
    //   83	88	142	java/lang/Exception
    //   94	102	142	java/lang/Exception
    //   105	119	142	java/lang/Exception
    //   122	128	142	java/lang/Exception
    //   134	139	142	java/lang/Exception
    //   73	80	172	finally
    //   83	88	172	finally
    //   94	102	172	finally
    //   105	119	172	finally
    //   122	128	172	finally
    //   134	139	172	finally
    //   147	152	172	finally
    //   158	163	172	finally
    //   182	185	172	finally
    //   73	80	177	java/lang/Throwable
    //   83	88	177	java/lang/Throwable
    //   94	102	177	java/lang/Throwable
    //   105	119	177	java/lang/Throwable
    //   122	128	177	java/lang/Throwable
    //   134	139	177	java/lang/Throwable
    //   147	152	177	java/lang/Throwable
    //   158	163	177	java/lang/Throwable
  }
  
  public <V extends View> V getPhotoWallDiyView(ProfileCardInfo paramProfileCardInfo)
  {
    return this.$$delegate_1.getPhotoWallDiyView(paramProfileCardInfo);
  }
  
  public <T extends View> T getQZoneDiyView(String paramString)
  {
    return this.$$delegate_1.getQZoneDiyView(paramString);
  }
  
  public Drawable getTemplateDrawable(ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    return this.$$delegate_0.getTemplateDrawable(paramProfileCardTemplate, paramBoolean1, paramBoolean2, paramString);
  }
  
  public void initDiyTemplate(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    this.$$delegate_1.initDiyTemplate(paramQBaseActivity, paramProfileCardInfo);
  }
  
  public boolean initTemplateConfig(ProfileCardTemplate paramProfileCardTemplate, long paramLong1, long paramLong2)
  {
    return this.$$delegate_0.initTemplateConfig(paramProfileCardTemplate, paramLong1, paramLong2);
  }
  
  public boolean isDiy()
  {
    return this.$$delegate_1.isDiy();
  }
  
  public boolean preNotifyOnCardUpdate(@NotNull QBaseActivity paramQBaseActivity, @NotNull ProfileCardInfo paramProfileCardInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramProfileCardInfo, "cardInfo");
    if (this.mVasProfileTemplateController == null) {
      this.mVasProfileTemplateController = ((IProfileTemplateController)new VasProfileTemplateController((Activity)this.mActivity, (Function0)new VasProfileTemplateComponent.preNotifyOnCardUpdate.1(this)));
    }
    IProfileTemplateController localIProfileTemplateController = this.mVasProfileTemplateController;
    if (localIProfileTemplateController == null) {
      Intrinsics.throwNpe();
    }
    boolean bool = localIProfileTemplateController.onCardUpdate(this.mComponentCenter, paramProfileCardInfo);
    initDiyTemplate(paramQBaseActivity, paramProfileCardInfo);
    return bool;
  }
  
  public void updateAccountInfoForDeepDiy(View paramView)
  {
    this.$$delegate_1.updateAccountInfoForDeepDiy(paramView);
  }
  
  public void updateBaseInfoForDeepDiy(View paramView)
  {
    this.$$delegate_1.updateBaseInfoForDeepDiy(paramView);
  }
  
  public void updateItemThemeForDIYTemplate(TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3, View paramView4)
  {
    this.$$delegate_1.updateItemThemeForDIYTemplate(paramTextView, paramView1, paramImageView, paramView2, paramView3, paramView4);
  }
  
  public void updateLevelForDeepDiy(View paramView)
  {
    this.$$delegate_1.updateLevelForDeepDiy(paramView);
  }
  
  public void updateMetalForDeepDiy(View paramView)
  {
    this.$$delegate_1.updateMetalForDeepDiy(paramView);
  }
  
  public void updatePhotoWallForDeepDiy(View paramView)
  {
    this.$$delegate_1.updatePhotoWallForDeepDiy(paramView);
  }
  
  public void updateQzoneForDeepDiy(View paramView)
  {
    this.$$delegate_1.updateQzoneForDeepDiy(paramView);
  }
  
  public void updateSignForDeepDiy(View paramView)
  {
    this.$$delegate_1.updateSignForDeepDiy(paramView);
  }
  
  public void updateTroopMemInfoForDeepDiy(View paramView)
  {
    this.$$delegate_1.updateTroopMemInfoForDeepDiy(paramView);
  }
  
  @SuppressLint({"NewApi"})
  public void updateViewAttr(View paramView, String paramString1, ProfileCardTemplate paramProfileCardTemplate, String paramString2)
  {
    this.$$delegate_0.updateViewAttr(paramView, paramString1, paramProfileCardTemplate, paramString2);
  }
  
  public void updateViewAttrForTemplate(@NotNull View paramView, @NotNull String paramString1, @NotNull ProfileCardTemplate paramProfileCardTemplate, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString1, "attr");
    Intrinsics.checkParameterIsNotNull(paramProfileCardTemplate, "currentTemplate");
    Intrinsics.checkParameterIsNotNull(paramString2, "attrKey");
    ProfileTemplateApi.getTemplateUtils(this.mComponentCenter).updateViewAttr(paramView, paramString1, paramProfileCardTemplate, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.template.VasProfileTemplateComponent
 * JD-Core Version:    0.7.0.1
 */