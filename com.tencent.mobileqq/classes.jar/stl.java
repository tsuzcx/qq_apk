import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import java.util.ArrayList;
import java.util.List;

public class stl
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<DiandianTopConfig> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public stl(List<DiandianTopConfig> paramList, int paramInt)
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
    //   1: getfield 21	stl:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: iload_1
    //   5: invokeinterface 33 2 0
    //   10: checkcast 57	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig
    //   13: astore 5
    //   15: aload_2
    //   16: ifnonnull +414 -> 430
    //   19: new 59	sto
    //   22: dup
    //   23: aconst_null
    //   24: invokespecial 62	sto:<init>	(Lstg;)V
    //   27: astore 4
    //   29: aload_3
    //   30: invokevirtual 68	android/view/ViewGroup:getContext	()Landroid/content/Context;
    //   33: invokestatic 74	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   36: ldc 75
    //   38: aconst_null
    //   39: invokevirtual 79	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   42: astore_2
    //   43: aload 4
    //   45: aload_2
    //   46: ldc 80
    //   48: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   51: checkcast 88	com/tencent/image/URLImageView
    //   54: putfield 91	sto:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   57: aload 4
    //   59: aload_2
    //   60: ldc 92
    //   62: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   65: checkcast 94	android/widget/TextView
    //   68: putfield 97	sto:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   71: aload 4
    //   73: aload_2
    //   74: ldc 98
    //   76: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   79: checkcast 94	android/widget/TextView
    //   82: putfield 101	sto:b	Landroid/widget/TextView;
    //   85: aload 4
    //   87: aload_2
    //   88: ldc 102
    //   90: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   93: checkcast 94	android/widget/TextView
    //   96: putfield 105	sto:c	Landroid/widget/TextView;
    //   99: aload 4
    //   101: new 107	stn
    //   104: dup
    //   105: aload_0
    //   106: getfield 13	stl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   109: aconst_null
    //   110: invokespecial 110	stn:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;Lstg;)V
    //   113: putfield 113	sto:jdField_a_of_type_Stn	Lstn;
    //   116: aload_2
    //   117: aload 4
    //   119: invokevirtual 117	android/view/View:setTag	(Ljava/lang/Object;)V
    //   122: aload_2
    //   123: aload 4
    //   125: getfield 113	sto:jdField_a_of_type_Stn	Lstn;
    //   128: invokevirtual 121	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   131: aload 4
    //   133: getfield 113	sto:jdField_a_of_type_Stn	Lstn;
    //   136: aload_0
    //   137: getfield 23	stl:jdField_a_of_type_Int	I
    //   140: iconst_2
    //   141: imul
    //   142: iload_1
    //   143: iadd
    //   144: putfield 122	stn:jdField_a_of_type_Int	I
    //   147: invokestatic 128	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   150: astore 6
    //   152: aload 6
    //   154: aload_0
    //   155: getfield 13	stl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   158: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	Landroid/graphics/drawable/ColorDrawable;
    //   161: putfield 137	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   164: aload 6
    //   166: aload_0
    //   167: getfield 13	stl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   170: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	Landroid/graphics/drawable/ColorDrawable;
    //   173: putfield 140	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   176: aload 6
    //   178: iconst_1
    //   179: putfield 144	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   182: aload 5
    //   184: getfield 148	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:picUrl	Ljava/lang/String;
    //   187: aload 6
    //   189: invokestatic 154	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   192: astore 6
    //   194: aload 6
    //   196: aload_2
    //   197: invokevirtual 155	android/view/View:getContext	()Landroid/content/Context;
    //   200: ldc 156
    //   202: invokestatic 161	bhgr:a	(Landroid/content/Context;F)I
    //   205: aload_2
    //   206: invokevirtual 155	android/view/View:getContext	()Landroid/content/Context;
    //   209: ldc 156
    //   211: invokestatic 161	bhgr:a	(Landroid/content/Context;F)I
    //   214: invokestatic 166	bhez:a	(II)[I
    //   217: invokevirtual 167	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   220: aload 4
    //   222: getfield 91	sto:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   225: aload 6
    //   227: invokevirtual 171	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   230: aload 6
    //   232: invokevirtual 174	com/tencent/image/URLDrawable:getStatus	()I
    //   235: iconst_1
    //   236: if_icmpeq +16 -> 252
    //   239: aload 6
    //   241: invokevirtual 174	com/tencent/image/URLDrawable:getStatus	()I
    //   244: ifeq +8 -> 252
    //   247: aload 6
    //   249: invokevirtual 177	com/tencent/image/URLDrawable:restartDownload	()V
    //   252: aload 5
    //   254: getfield 180	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:type	I
    //   257: iconst_3
    //   258: if_icmpne +184 -> 442
    //   261: aload 4
    //   263: getfield 97	sto:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   266: iconst_0
    //   267: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
    //   270: aload 4
    //   272: getfield 101	sto:b	Landroid/widget/TextView;
    //   275: aload 5
    //   277: getfield 187	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:title	Ljava/lang/String;
    //   280: invokevirtual 191	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   283: aload 5
    //   285: getfield 194	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
    //   288: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +234 -> 525
    //   294: aload 4
    //   296: getfield 105	sto:c	Landroid/widget/TextView;
    //   299: aload 5
    //   301: getfield 194	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
    //   304: invokestatic 206	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   307: invokevirtual 209	android/widget/TextView:setTextColor	(I)V
    //   310: aload 4
    //   312: getfield 105	sto:c	Landroid/widget/TextView;
    //   315: aload 5
    //   317: getfield 212	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitle	Ljava/lang/String;
    //   320: invokevirtual 191	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   323: aload_0
    //   324: getfield 13	stl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   327: invokestatic 215	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:c	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;)Z
    //   330: ifne +84 -> 414
    //   333: new 217	org/json/JSONObject
    //   336: dup
    //   337: invokespecial 218	org/json/JSONObject:<init>	()V
    //   340: astore 4
    //   342: aload 4
    //   344: ldc 220
    //   346: getstatic 225	ozs:d	I
    //   349: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   352: pop
    //   353: aconst_null
    //   354: ldc 231
    //   356: ldc 233
    //   358: ldc 233
    //   360: iconst_0
    //   361: iconst_0
    //   362: new 235	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   369: aload_0
    //   370: getfield 13	stl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   373: invokestatic 239	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:b	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;)Ljava/util/List;
    //   376: invokeinterface 29 1 0
    //   381: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: ldc 231
    //   386: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: ldc 231
    //   394: ldc 231
    //   396: aload 4
    //   398: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   401: iconst_0
    //   402: invokestatic 256	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   405: aload_0
    //   406: getfield 13	stl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   409: iconst_1
    //   410: invokestatic 259	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;Z)Z
    //   413: pop
    //   414: invokestatic 265	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   417: iload_1
    //   418: aload_2
    //   419: aload_3
    //   420: aload_0
    //   421: iload_1
    //   422: invokevirtual 267	stl:getItemId	(I)J
    //   425: invokevirtual 271	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
    //   428: aload_2
    //   429: areturn
    //   430: aload_2
    //   431: invokevirtual 275	android/view/View:getTag	()Ljava/lang/Object;
    //   434: checkcast 59	sto
    //   437: astore 4
    //   439: goto -308 -> 131
    //   442: aload 4
    //   444: getfield 97	sto:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   447: bipush 8
    //   449: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
    //   452: goto -182 -> 270
    //   455: astore 6
    //   457: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +48 -> 508
    //   463: ldc_w 283
    //   466: iconst_2
    //   467: new 235	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   474: ldc_w 285
    //   477: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload 5
    //   482: getfield 194	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
    //   485: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: ldc_w 287
    //   491: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload 6
    //   496: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   499: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: aload 4
    //   510: getfield 105	sto:c	Landroid/widget/TextView;
    //   513: ldc_w 294
    //   516: invokestatic 206	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   519: invokevirtual 209	android/widget/TextView:setTextColor	(I)V
    //   522: goto -212 -> 310
    //   525: aload 4
    //   527: getfield 105	sto:c	Landroid/widget/TextView;
    //   530: ldc_w 294
    //   533: invokestatic 206	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   536: invokevirtual 209	android/widget/TextView:setTextColor	(I)V
    //   539: goto -229 -> 310
    //   542: astore 4
    //   544: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq -133 -> 414
    //   550: ldc_w 283
    //   553: iconst_2
    //   554: aload 4
    //   556: invokevirtual 295	org/json/JSONException:toString	()Ljava/lang/String;
    //   559: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: goto -148 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	this	stl
    //   0	565	1	paramInt	int
    //   0	565	2	paramView	android.view.View
    //   0	565	3	paramViewGroup	android.view.ViewGroup
    //   27	499	4	localObject1	Object
    //   542	13	4	localJSONException	org.json.JSONException
    //   13	468	5	localDiandianTopConfig	DiandianTopConfig
    //   150	98	6	localObject2	Object
    //   455	40	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   294	310	455	java/lang/Exception
    //   333	414	542	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stl
 * JD-Core Version:    0.7.0.1
 */