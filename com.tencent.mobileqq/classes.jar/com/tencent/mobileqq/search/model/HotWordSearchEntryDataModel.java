package com.tencent.mobileqq.search.model;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import bbgu;
import bbmt;
import bbof;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tdi;

public class HotWordSearchEntryDataModel
  extends bbof
{
  public final bbmt a;
  public final HotWordSearchEntryDataModel.GIFInfo a;
  public final List<HotWordSearchEntryDataModel.HotSearchItem> a;
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bbmt = new bbmt(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo = new HotWordSearchEntryDataModel.GIFInfo();
  }
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bbmt = new bbmt(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo = new HotWordSearchEntryDataModel.GIFInfo();
    a(paramArrayOfByte);
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (localAppRuntime != null)
    {
      if (!paramBoolean) {}
      for (long l = localSharedPreferences.getLong("search_discovery_sp_prefixlast_update_time" + localAppRuntime.getAccount() + "_" + paramInt, 0L); System.currentTimeMillis() - l > 86400000L; l = localSharedPreferences.getLong("search_discovery_sp_prefix_unifylast_update_time" + localAppRuntime.getAccount() + "_" + paramInt, 0L)) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public List<HotWordSearchEntryDataModel.HotSearchItem> a()
  {
    int i = -1;
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        return localObject;
      }
      Object localObject = Aladdin.getConfig(313);
      if (localObject != null) {
        i = ((AladdinConfig)localObject).getIntegerFromString("SearchPage_UIType", -1);
      }
      if (i == 5) {
        return this.jdField_a_of_type_JavaUtilList;
      }
      int n = bbgu.jdField_a_of_type_Int;
      localObject = bbgu.b;
      int j = tdi.jdField_a_of_type_Int * n;
      i = j;
      if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        tdi.jdField_a_of_type_Int = 0;
        if (TextUtils.equals((CharSequence)localObject, "Recom_word")) {
          tdi.b = 0;
        }
        i = 0;
      }
      int m = i + n;
      j = m;
      if (m > this.jdField_a_of_type_JavaUtilList.size() - 1) {
        j = this.jdField_a_of_type_JavaUtilList.size() - 1;
      }
      List localList = this.jdField_a_of_type_JavaUtilList.subList(i, j);
      i = k;
      for (;;)
      {
        localObject = localList;
        if (localList.size() >= n) {
          break;
        }
        localObject = localList;
        if (i >= this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break;
        }
        localList.add(this.jdField_a_of_type_JavaUtilList.get(i));
        i += 1;
      }
    }
    return null;
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 164	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Boolean	Z
    //   9: ifne +750 -> 759
    //   12: new 166	pb/unite/search/DynamicDiscovery$Result
    //   15: dup
    //   16: invokespecial 167	pb/unite/search/DynamicDiscovery$Result:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: aload_1
    //   24: invokevirtual 171	pb/unite/search/DynamicDiscovery$Result:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: pop
    //   28: aload 4
    //   30: getfield 175	pb/unite/search/DynamicDiscovery$Result:hot_search_gif_item	Lpb/unite/search/DynamicDiscovery$GifInfoItem;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +54 -> 89
    //   38: aload_0
    //   39: getfield 32	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   42: aload_1
    //   43: getfield 181	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   46: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   49: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   52: putfield 194	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotSearchGifUrl	Ljava/lang/String;
    //   55: aload_0
    //   56: getfield 32	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   59: aload_1
    //   60: getfield 197	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_url_night	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   63: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   66: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   69: putfield 200	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotSearchGifUrlNight	Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 32	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   76: aload_1
    //   77: getfield 203	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   80: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   83: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   86: putfield 206	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotSearchGifID	Ljava/lang/String;
    //   89: aload 4
    //   91: getfield 209	pb/unite/search/DynamicDiscovery$Result:hot_wrod_gif_item	Lpb/unite/search/DynamicDiscovery$GifInfoItem;
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +37 -> 133
    //   99: aload_0
    //   100: getfield 32	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   103: aload_1
    //   104: getfield 181	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   107: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   110: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   113: putfield 212	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotWordGifUrl	Ljava/lang/String;
    //   116: aload_0
    //   117: getfield 32	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   120: aload_1
    //   121: getfield 197	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_url_night	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   124: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   127: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   130: putfield 215	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotWordGifUrlNight	Ljava/lang/String;
    //   133: aload 4
    //   135: getfield 219	pb/unite/search/DynamicDiscovery$Result:hot_search_items	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   138: invokevirtual 223	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   141: astore_1
    //   142: aload 4
    //   144: getfield 227	pb/unite/search/DynamicDiscovery$Result:title_header	Lpb/unite/search/DynamicDiscovery$TitleHeaderItem;
    //   147: invokevirtual 232	pb/unite/search/DynamicDiscovery$TitleHeaderItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: checkcast 229	pb/unite/search/DynamicDiscovery$TitleHeaderItem
    //   153: astore_3
    //   154: aload_0
    //   155: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   158: aload_3
    //   159: getfield 235	pb/unite/search/DynamicDiscovery$TitleHeaderItem:icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   162: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   165: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   168: putfield 236	bbmt:b	Ljava/lang/String;
    //   171: aload_0
    //   172: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   175: aload_3
    //   176: getfield 239	pb/unite/search/DynamicDiscovery$TitleHeaderItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   179: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   182: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   185: putfield 241	bbmt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: aload_0
    //   189: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   192: aload_3
    //   193: getfield 244	pb/unite/search/DynamicDiscovery$TitleHeaderItem:morn_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   196: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   199: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   202: putfield 247	bbmt:c	Ljava/lang/String;
    //   205: aload_0
    //   206: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   209: aload_3
    //   210: getfield 250	pb/unite/search/DynamicDiscovery$TitleHeaderItem:morn_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   216: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   219: putfield 253	bbmt:d	Ljava/lang/String;
    //   222: aload_0
    //   223: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   226: aload_3
    //   227: getfield 257	pb/unite/search/DynamicDiscovery$TitleHeaderItem:header_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   230: invokevirtual 261	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   233: putfield 262	bbmt:jdField_a_of_type_Int	I
    //   236: aload_3
    //   237: getfield 265	pb/unite/search/DynamicDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   240: invokevirtual 269	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   243: ifeq +20 -> 263
    //   246: aload_0
    //   247: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   250: aload_3
    //   251: getfield 265	pb/unite/search/DynamicDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   260: putfield 272	bbmt:e	Ljava/lang/String;
    //   263: aload_0
    //   264: getfield 20	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   267: invokeinterface 275 1 0
    //   272: aload_0
    //   273: getfield 276	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:b	I
    //   276: iconst_0
    //   277: invokestatic 278	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:a	(IZ)Z
    //   280: ifne +426 -> 706
    //   283: aload_1
    //   284: invokeinterface 282 1 0
    //   289: astore 5
    //   291: aload 5
    //   293: invokeinterface 287 1 0
    //   298: ifeq +408 -> 706
    //   301: aload 5
    //   303: invokeinterface 291 1 0
    //   308: checkcast 293	pb/unite/search/DynamicDiscovery$HotSearchItem
    //   311: astore 7
    //   313: aload 7
    //   315: getfield 296	pb/unite/search/DynamicDiscovery$HotSearchItem:item_ext	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   318: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   321: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   324: astore 8
    //   326: new 298	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem
    //   329: dup
    //   330: invokespecial 299	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:<init>	()V
    //   333: astore 6
    //   335: aload 6
    //   337: aload 7
    //   339: getfield 300	pb/unite/search/DynamicDiscovery$HotSearchItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   342: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   345: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   348: putfield 302	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   351: aload 6
    //   353: aload 4
    //   355: getfield 305	pb/unite/search/DynamicDiscovery$Result:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   358: invokevirtual 261	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   361: putfield 307	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:type	I
    //   364: aload 6
    //   366: aload 7
    //   368: getfield 310	pb/unite/search/DynamicDiscovery$HotSearchItem:show_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   371: invokevirtual 261	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   374: putfield 313	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showType	I
    //   377: aload 6
    //   379: aload 7
    //   381: getfield 316	pb/unite/search/DynamicDiscovery$HotSearchItem:wz_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   384: invokevirtual 261	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   387: putfield 319	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showCount	I
    //   390: aload 7
    //   392: getfield 322	pb/unite/search/DynamicDiscovery$HotSearchItem:recall_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   395: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   398: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   401: astore_3
    //   402: aload_3
    //   403: astore_1
    //   404: aload_3
    //   405: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifeq +9 -> 417
    //   411: aload 6
    //   413: getfield 302	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   416: astore_1
    //   417: aload 6
    //   419: aload_1
    //   420: putfield 329	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:recallWord	Ljava/lang/String;
    //   423: aload 6
    //   425: aload 7
    //   427: getfield 332	pb/unite/search/DynamicDiscovery$HotSearchItem:img_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   430: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   433: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   436: putfield 335	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgUrl	Ljava/lang/String;
    //   439: aload 6
    //   441: aload 7
    //   443: getfield 338	pb/unite/search/DynamicDiscovery$HotSearchItem:detail_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   446: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   449: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   452: putfield 341	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:detailText	Ljava/lang/String;
    //   455: aload 6
    //   457: aload 7
    //   459: getfield 344	pb/unite/search/DynamicDiscovery$HotSearchItem:jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   462: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   465: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   468: putfield 347	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:jumpUrl	Ljava/lang/String;
    //   471: aload 6
    //   473: aload 7
    //   475: getfield 350	pb/unite/search/DynamicDiscovery$HotSearchItem:mark_text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   478: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   481: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   484: putfield 353	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexTextColor	Ljava/lang/String;
    //   487: aload 6
    //   489: aload 7
    //   491: getfield 356	pb/unite/search/DynamicDiscovery$HotSearchItem:mark_bg_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   494: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   497: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   500: putfield 359	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexBgColor	Ljava/lang/String;
    //   503: aload 6
    //   505: aload 7
    //   507: getfield 362	pb/unite/search/DynamicDiscovery$HotSearchItem:img_bg_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   510: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   513: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   516: putfield 365	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgBgUrl	Ljava/lang/String;
    //   519: aload 6
    //   521: aload 7
    //   523: getfield 368	pb/unite/search/DynamicDiscovery$HotSearchItem:text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   526: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   529: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   532: putfield 371	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:titleTextColor	Ljava/lang/String;
    //   535: aload 6
    //   537: aload 7
    //   539: getfield 374	pb/unite/search/DynamicDiscovery$HotSearchItem:right_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   542: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   545: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   548: putfield 377	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:rightIconUrl	Ljava/lang/String;
    //   551: aload 8
    //   553: invokevirtual 381	java/lang/String:isEmpty	()Z
    //   556: istore_2
    //   557: iload_2
    //   558: ifne +99 -> 657
    //   561: new 383	org/json/JSONObject
    //   564: dup
    //   565: aload 8
    //   567: invokespecial 386	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   570: astore_1
    //   571: aload 6
    //   573: aload_1
    //   574: ldc_w 388
    //   577: invokevirtual 392	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   580: putfield 394	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:tagColor	Ljava/lang/String;
    //   583: aload 6
    //   585: aload_1
    //   586: ldc_w 396
    //   589: invokevirtual 392	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   592: putfield 398	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:tagInfo	Ljava/lang/String;
    //   595: aload 6
    //   597: aload_1
    //   598: ldc_w 400
    //   601: invokevirtual 392	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   604: putfield 402	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:tagBGColor	Ljava/lang/String;
    //   607: aload 6
    //   609: aload_1
    //   610: ldc_w 404
    //   613: invokevirtual 392	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   616: putfield 407	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:countText	Ljava/lang/String;
    //   619: aload 6
    //   621: aload_1
    //   622: ldc_w 409
    //   625: invokevirtual 392	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   628: putfield 411	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:sAppend	Ljava/lang/String;
    //   631: aload_1
    //   632: ldc_w 413
    //   635: invokevirtual 392	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   638: astore_1
    //   639: aload_1
    //   640: ldc_w 415
    //   643: invokestatic 141	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   646: ifeq +71 -> 717
    //   649: aload 6
    //   651: ldc_w 417
    //   654: putfield 420	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:badgeUrl	Ljava/lang/String;
    //   657: aload_0
    //   658: getfield 20	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   661: aload 6
    //   663: invokeinterface 155 2 0
    //   668: pop
    //   669: goto -378 -> 291
    //   672: astore_1
    //   673: invokestatic 425	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   676: ifeq +30 -> 706
    //   679: ldc_w 427
    //   682: iconst_2
    //   683: new 62	java/lang/StringBuilder
    //   686: dup
    //   687: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   690: ldc_w 429
    //   693: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload_1
    //   697: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   706: ldc_w 437
    //   709: iconst_2
    //   710: ldc_w 439
    //   713: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   716: return
    //   717: aload_1
    //   718: ldc_w 443
    //   721: invokestatic 141	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   724: ifeq +14 -> 738
    //   727: aload 6
    //   729: ldc_w 445
    //   732: putfield 420	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:badgeUrl	Ljava/lang/String;
    //   735: goto -78 -> 657
    //   738: aload_1
    //   739: ldc_w 447
    //   742: invokestatic 141	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   745: ifeq -88 -> 657
    //   748: aload 6
    //   750: ldc_w 449
    //   753: putfield 420	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:badgeUrl	Ljava/lang/String;
    //   756: goto -99 -> 657
    //   759: new 451	pb/unify/search/UnifySearchDiscovery$Result
    //   762: dup
    //   763: invokespecial 452	pb/unify/search/UnifySearchDiscovery$Result:<init>	()V
    //   766: astore 4
    //   768: aload 4
    //   770: aload_1
    //   771: invokevirtual 453	pb/unify/search/UnifySearchDiscovery$Result:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   774: pop
    //   775: aload 4
    //   777: getfield 454	pb/unify/search/UnifySearchDiscovery$Result:hot_search_items	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   780: invokevirtual 223	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   783: astore_1
    //   784: aload 4
    //   786: getfield 457	pb/unify/search/UnifySearchDiscovery$Result:title_header	Lpb/unify/search/UnifySearchDiscovery$TitleHeaderItem;
    //   789: invokevirtual 460	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   792: checkcast 459	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem
    //   795: astore_3
    //   796: aload_0
    //   797: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   800: aload_3
    //   801: getfield 461	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   804: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   807: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   810: putfield 236	bbmt:b	Ljava/lang/String;
    //   813: aload_0
    //   814: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   817: aload_3
    //   818: getfield 462	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   821: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   824: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   827: putfield 241	bbmt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   830: aload_0
    //   831: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   834: aload_3
    //   835: getfield 463	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:morn_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   838: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   841: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   844: putfield 247	bbmt:c	Ljava/lang/String;
    //   847: aload_0
    //   848: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   851: aload_3
    //   852: getfield 464	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:morn_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   855: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   858: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   861: putfield 253	bbmt:d	Ljava/lang/String;
    //   864: aload_0
    //   865: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   868: aload_3
    //   869: getfield 465	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:header_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   872: invokevirtual 261	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   875: putfield 262	bbmt:jdField_a_of_type_Int	I
    //   878: aload_3
    //   879: getfield 466	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   882: invokevirtual 269	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   885: ifeq +20 -> 905
    //   888: aload_0
    //   889: getfield 27	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Bbmt	Lbbmt;
    //   892: aload_3
    //   893: getfield 466	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   896: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   899: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   902: putfield 272	bbmt:e	Ljava/lang/String;
    //   905: aload_0
    //   906: getfield 20	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   909: invokeinterface 275 1 0
    //   914: aload_0
    //   915: getfield 276	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:b	I
    //   918: iconst_1
    //   919: invokestatic 278	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:a	(IZ)Z
    //   922: ifne +307 -> 1229
    //   925: aload_1
    //   926: invokeinterface 282 1 0
    //   931: astore 5
    //   933: aload 5
    //   935: invokeinterface 287 1 0
    //   940: ifeq +289 -> 1229
    //   943: aload 5
    //   945: invokeinterface 291 1 0
    //   950: checkcast 468	pb/unify/search/UnifySearchDiscovery$HotSearchItem
    //   953: astore 6
    //   955: new 298	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem
    //   958: dup
    //   959: invokespecial 299	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:<init>	()V
    //   962: astore 7
    //   964: aload 7
    //   966: aload 6
    //   968: getfield 469	pb/unify/search/UnifySearchDiscovery$HotSearchItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   971: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   974: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   977: putfield 302	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   980: aload 7
    //   982: aload 4
    //   984: getfield 470	pb/unify/search/UnifySearchDiscovery$Result:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   987: invokevirtual 261	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   990: putfield 307	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:type	I
    //   993: aload 7
    //   995: aload 6
    //   997: getfield 471	pb/unify/search/UnifySearchDiscovery$HotSearchItem:show_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1000: invokevirtual 261	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1003: putfield 313	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showType	I
    //   1006: aload 7
    //   1008: aload 6
    //   1010: getfield 472	pb/unify/search/UnifySearchDiscovery$HotSearchItem:wz_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1013: invokevirtual 261	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1016: putfield 319	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showCount	I
    //   1019: aload 6
    //   1021: getfield 473	pb/unify/search/UnifySearchDiscovery$HotSearchItem:recall_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1024: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1027: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1030: astore_3
    //   1031: aload_3
    //   1032: astore_1
    //   1033: aload_3
    //   1034: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1037: ifeq +9 -> 1046
    //   1040: aload 7
    //   1042: getfield 302	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   1045: astore_1
    //   1046: aload 7
    //   1048: aload_1
    //   1049: putfield 329	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:recallWord	Ljava/lang/String;
    //   1052: aload 7
    //   1054: aload 6
    //   1056: getfield 474	pb/unify/search/UnifySearchDiscovery$HotSearchItem:img_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1059: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1062: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1065: putfield 335	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgUrl	Ljava/lang/String;
    //   1068: aload 7
    //   1070: aload 6
    //   1072: getfield 475	pb/unify/search/UnifySearchDiscovery$HotSearchItem:detail_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1075: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1078: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1081: putfield 341	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:detailText	Ljava/lang/String;
    //   1084: aload 7
    //   1086: aload 6
    //   1088: getfield 476	pb/unify/search/UnifySearchDiscovery$HotSearchItem:jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1091: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1094: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1097: putfield 347	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:jumpUrl	Ljava/lang/String;
    //   1100: aload 7
    //   1102: aload 6
    //   1104: getfield 477	pb/unify/search/UnifySearchDiscovery$HotSearchItem:mark_text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1107: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1110: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1113: putfield 353	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexTextColor	Ljava/lang/String;
    //   1116: aload 7
    //   1118: aload 6
    //   1120: getfield 478	pb/unify/search/UnifySearchDiscovery$HotSearchItem:mark_bg_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1123: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1126: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1129: putfield 359	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexBgColor	Ljava/lang/String;
    //   1132: aload 7
    //   1134: aload 6
    //   1136: getfield 479	pb/unify/search/UnifySearchDiscovery$HotSearchItem:img_bg_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1139: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1142: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1145: putfield 365	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgBgUrl	Ljava/lang/String;
    //   1148: aload 7
    //   1150: aload 6
    //   1152: getfield 480	pb/unify/search/UnifySearchDiscovery$HotSearchItem:text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1155: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1158: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1161: putfield 371	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:titleTextColor	Ljava/lang/String;
    //   1164: aload 7
    //   1166: aload 6
    //   1168: getfield 481	pb/unify/search/UnifySearchDiscovery$HotSearchItem:right_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1171: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1174: invokevirtual 191	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1177: putfield 377	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:rightIconUrl	Ljava/lang/String;
    //   1180: aload_0
    //   1181: getfield 20	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1184: aload 7
    //   1186: invokeinterface 155 2 0
    //   1191: pop
    //   1192: goto -259 -> 933
    //   1195: astore_1
    //   1196: invokestatic 425	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1199: ifeq +30 -> 1229
    //   1202: ldc_w 427
    //   1205: iconst_2
    //   1206: new 62	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1213: ldc_w 483
    //   1216: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: aload_1
    //   1220: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1223: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1226: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1229: ldc_w 485
    //   1232: iconst_2
    //   1233: ldc_w 439
    //   1236: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1239: return
    //   1240: astore_1
    //   1241: goto -584 -> 657
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1244	0	this	HotWordSearchEntryDataModel
    //   0	1244	1	paramArrayOfByte	byte[]
    //   556	2	2	bool	boolean
    //   153	881	3	localObject1	Object
    //   19	964	4	localObject2	Object
    //   289	655	5	localIterator	java.util.Iterator
    //   333	834	6	localObject3	Object
    //   311	874	7	localObject4	Object
    //   324	242	8	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   21	34	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   38	89	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   89	95	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   99	133	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   133	263	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   263	291	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   291	402	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   404	417	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   417	557	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   561	657	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   657	669	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   717	735	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   738	756	672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   768	905	1195	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   905	933	1195	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   933	1031	1195	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1033	1046	1195	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1046	1192	1195	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   561	657	1240	org/json/JSONException
    //   717	735	1240	org/json/JSONException
    //   738	756	1240	org/json/JSONException
  }
  
  public List<HotWordSearchEntryDataModel.HotSearchItem> b()
  {
    int i = -1;
    int k = 0;
    Object localObject;
    int n;
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      if (this.jdField_a_of_type_Int == 1) {
        return this.jdField_a_of_type_JavaUtilList;
      }
      localObject = Aladdin.getConfig(313);
      if (localObject != null) {
        i = ((AladdinConfig)localObject).getIntegerFromString("SearchPage_UIType", -1);
      }
      if (i == 5)
      {
        n = ((AladdinConfig)localObject).getIntegerFromString("SearchPage_RwordNum", 20);
        if (UniteSearchActivity.a == null) {
          break label244;
        }
        i = 0;
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label244;
        }
        if (!TextUtils.equals(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(i)).title, UniteSearchActivity.a.title)) {}
      }
    }
    for (;;)
    {
      int m = i + n;
      int j = m;
      if (m > this.jdField_a_of_type_JavaUtilList.size()) {
        j = this.jdField_a_of_type_JavaUtilList.size();
      }
      localObject = new ArrayList();
      ((List)localObject).addAll(this.jdField_a_of_type_JavaUtilList.subList(i, j));
      i = k;
      for (;;)
      {
        if ((i < this.jdField_a_of_type_JavaUtilList.size() - 1) && (((List)localObject).size() < n))
        {
          ((List)localObject).add(this.jdField_a_of_type_JavaUtilList.get(i));
          i += 1;
          continue;
          i += 1;
          break;
        }
      }
      return localObject;
      return null;
      label244:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */