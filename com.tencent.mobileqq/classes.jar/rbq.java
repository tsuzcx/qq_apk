import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import java.util.ArrayList;
import java.util.List;

public class rbq
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<DiandianTopConfig> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public rbq(List<DiandianTopConfig> paramList, int paramInt)
  {
    this.jdField_a_of_type_Int = i;
    int j = i * 2;
    int i = j;
    while ((i < paramInt.size()) && (i < j + 2))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramInt.get(i));
      i += 1;
    }
  }
  
  public Object a(int paramInt, DiandianTopConfig paramDiandianTopConfig)
  {
    return this.jdField_a_of_type_JavaUtilList.set(paramInt, paramDiandianTopConfig);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  /* Error */
  public android.view.View getView(int paramInt, android.view.View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	rbq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: iload_1
    //   5: invokeinterface 33 2 0
    //   10: checkcast 57	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig
    //   13: astore 5
    //   15: aload_2
    //   16: ifnonnull +395 -> 411
    //   19: new 59	rbt
    //   22: dup
    //   23: aconst_null
    //   24: invokespecial 62	rbt:<init>	(Lrbh;)V
    //   27: astore_2
    //   28: aload_3
    //   29: invokevirtual 68	android/view/ViewGroup:getContext	()Landroid/content/Context;
    //   32: invokestatic 74	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   35: ldc 75
    //   37: aconst_null
    //   38: invokevirtual 79	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   41: astore 4
    //   43: aload_2
    //   44: aload 4
    //   46: ldc 80
    //   48: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   51: checkcast 88	com/tencent/image/URLImageView
    //   54: putfield 91	rbt:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   57: aload_2
    //   58: aload 4
    //   60: ldc 92
    //   62: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   65: checkcast 94	android/widget/TextView
    //   68: putfield 97	rbt:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   71: aload_2
    //   72: aload 4
    //   74: ldc 98
    //   76: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   79: checkcast 94	android/widget/TextView
    //   82: putfield 101	rbt:b	Landroid/widget/TextView;
    //   85: aload_2
    //   86: aload 4
    //   88: ldc 102
    //   90: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   93: checkcast 94	android/widget/TextView
    //   96: putfield 105	rbt:c	Landroid/widget/TextView;
    //   99: aload_2
    //   100: new 107	rbs
    //   103: dup
    //   104: aload_0
    //   105: getfield 13	rbq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   108: aconst_null
    //   109: invokespecial 110	rbs:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;Lrbh;)V
    //   112: putfield 113	rbt:jdField_a_of_type_Rbs	Lrbs;
    //   115: aload 4
    //   117: aload_2
    //   118: invokevirtual 117	android/view/View:setTag	(Ljava/lang/Object;)V
    //   121: aload 4
    //   123: aload_2
    //   124: getfield 113	rbt:jdField_a_of_type_Rbs	Lrbs;
    //   127: invokevirtual 121	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   130: aload_2
    //   131: astore_3
    //   132: aload 4
    //   134: astore_2
    //   135: aload_3
    //   136: getfield 113	rbt:jdField_a_of_type_Rbs	Lrbs;
    //   139: aload_0
    //   140: getfield 23	rbq:jdField_a_of_type_Int	I
    //   143: iconst_2
    //   144: imul
    //   145: iload_1
    //   146: iadd
    //   147: putfield 122	rbs:jdField_a_of_type_Int	I
    //   150: invokestatic 128	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   153: astore 4
    //   155: aload 4
    //   157: aload_0
    //   158: getfield 13	rbq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   161: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	Landroid/graphics/drawable/ColorDrawable;
    //   164: putfield 137	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   167: aload 4
    //   169: aload_0
    //   170: getfield 13	rbq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   173: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	Landroid/graphics/drawable/ColorDrawable;
    //   176: putfield 140	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   179: aload 4
    //   181: iconst_1
    //   182: putfield 144	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   185: aload 5
    //   187: getfield 148	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:picUrl	Ljava/lang/String;
    //   190: aload 4
    //   192: invokestatic 154	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   195: astore 4
    //   197: aload 4
    //   199: aload_2
    //   200: invokevirtual 155	android/view/View:getContext	()Landroid/content/Context;
    //   203: ldc 156
    //   205: invokestatic 161	azvv:a	(Landroid/content/Context;F)I
    //   208: aload_2
    //   209: invokevirtual 155	android/view/View:getContext	()Landroid/content/Context;
    //   212: ldc 156
    //   214: invokestatic 161	azvv:a	(Landroid/content/Context;F)I
    //   217: invokestatic 166	azue:a	(II)[I
    //   220: invokevirtual 167	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   223: aload_3
    //   224: getfield 91	rbt:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   227: aload 4
    //   229: invokevirtual 171	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   232: aload 4
    //   234: invokevirtual 174	com/tencent/image/URLDrawable:getStatus	()I
    //   237: iconst_1
    //   238: if_icmpeq +16 -> 254
    //   241: aload 4
    //   243: invokevirtual 174	com/tencent/image/URLDrawable:getStatus	()I
    //   246: ifeq +8 -> 254
    //   249: aload 4
    //   251: invokevirtual 177	com/tencent/image/URLDrawable:restartDownload	()V
    //   254: aload 5
    //   256: getfield 180	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:type	I
    //   259: iconst_3
    //   260: if_icmpne +162 -> 422
    //   263: aload_3
    //   264: getfield 97	rbt:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   267: iconst_0
    //   268: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
    //   271: aload_3
    //   272: getfield 101	rbt:b	Landroid/widget/TextView;
    //   275: aload 5
    //   277: getfield 187	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:title	Ljava/lang/String;
    //   280: invokevirtual 191	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   283: aload 5
    //   285: getfield 194	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
    //   288: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +212 -> 503
    //   294: aload_3
    //   295: getfield 105	rbt:c	Landroid/widget/TextView;
    //   298: aload 5
    //   300: getfield 194	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
    //   303: invokestatic 206	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   306: invokevirtual 209	android/widget/TextView:setTextColor	(I)V
    //   309: aload_3
    //   310: getfield 105	rbt:c	Landroid/widget/TextView;
    //   313: aload 5
    //   315: getfield 212	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitle	Ljava/lang/String;
    //   318: invokevirtual 191	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   321: aload_0
    //   322: getfield 13	rbq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   325: invokestatic 215	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:c	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;)Z
    //   328: ifne +81 -> 409
    //   331: new 217	org/json/JSONObject
    //   334: dup
    //   335: invokespecial 218	org/json/JSONObject:<init>	()V
    //   338: astore_3
    //   339: aload_3
    //   340: ldc 220
    //   342: getstatic 225	obz:d	I
    //   345: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   348: pop
    //   349: aconst_null
    //   350: ldc 231
    //   352: ldc 233
    //   354: ldc 233
    //   356: iconst_0
    //   357: iconst_0
    //   358: new 235	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   365: aload_0
    //   366: getfield 13	rbq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   369: invokestatic 239	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:b	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;)Ljava/util/List;
    //   372: invokeinterface 29 1 0
    //   377: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: ldc 231
    //   382: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: ldc 231
    //   390: ldc 231
    //   392: aload_3
    //   393: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   396: iconst_0
    //   397: invokestatic 256	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   400: aload_0
    //   401: getfield 13	rbq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   404: iconst_1
    //   405: invokestatic 259	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;Z)Z
    //   408: pop
    //   409: aload_2
    //   410: areturn
    //   411: aload_2
    //   412: invokevirtual 263	android/view/View:getTag	()Ljava/lang/Object;
    //   415: checkcast 59	rbt
    //   418: astore_3
    //   419: goto -284 -> 135
    //   422: aload_3
    //   423: getfield 97	rbt:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   426: bipush 8
    //   428: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
    //   431: goto -160 -> 271
    //   434: astore 4
    //   436: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +48 -> 487
    //   442: ldc_w 271
    //   445: iconst_2
    //   446: new 235	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 273
    //   456: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 5
    //   461: getfield 194	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
    //   464: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc_w 275
    //   470: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 4
    //   475: invokevirtual 276	java/lang/Exception:toString	()Ljava/lang/String;
    //   478: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: aload_3
    //   488: getfield 105	rbt:c	Landroid/widget/TextView;
    //   491: ldc_w 282
    //   494: invokestatic 206	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   497: invokevirtual 209	android/widget/TextView:setTextColor	(I)V
    //   500: goto -191 -> 309
    //   503: aload_3
    //   504: getfield 105	rbt:c	Landroid/widget/TextView;
    //   507: ldc_w 282
    //   510: invokestatic 206	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   513: invokevirtual 209	android/widget/TextView:setTextColor	(I)V
    //   516: goto -207 -> 309
    //   519: astore_3
    //   520: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   523: ifeq -114 -> 409
    //   526: ldc_w 271
    //   529: iconst_2
    //   530: aload_3
    //   531: invokevirtual 283	org/json/JSONException:toString	()Ljava/lang/String;
    //   534: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: aload_2
    //   538: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	rbq
    //   0	539	1	paramInt	int
    //   0	539	2	paramView	android.view.View
    //   0	539	3	paramViewGroup	android.view.ViewGroup
    //   41	209	4	localObject	Object
    //   434	40	4	localException	java.lang.Exception
    //   13	447	5	localDiandianTopConfig	DiandianTopConfig
    // Exception table:
    //   from	to	target	type
    //   294	309	434	java/lang/Exception
    //   331	409	519	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rbq
 * JD-Core Version:    0.7.0.1
 */