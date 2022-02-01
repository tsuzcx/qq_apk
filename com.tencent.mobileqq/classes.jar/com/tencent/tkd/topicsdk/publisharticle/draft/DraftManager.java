package com.tencent.tkd.topicsdk.publisharticle.draft;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tkd.topicsdk.bean.DraftArticleInfo;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.OriginContentInfo;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.common.SerializableKt;
import com.tencent.tkd.topicsdk.common.db.DatabaseHelper;
import com.tencent.tkd.topicsdk.common.db.DatabaseHelper.Companion;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/draft/DraftManager;", "", "()V", "userId", "", "getUserId", "()Ljava/lang/String;", "clear", "", "clearDraftInfoInDB", "delete", "key", "deleteDraftInfoInDB", "getDraftInfoKey", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "tweetTopicItem", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "originContentInfo", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "getQueryAllDraftInfoCursor", "Landroid/database/Cursor;", "db", "Landroid/database/sqlite/SQLiteDatabase;", "getQueryInfoCursor", "hasDraft", "", "hasDraftInfoInDB", "queryAllDraftInfoInDB", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/publisharticle/draft/DraftBoxItem;", "Lkotlin/collections/ArrayList;", "queryDraftInfoInDB", "", "restore", "Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "save", "", "info", "updateDraftInfoToDB", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DraftManager
{
  public static final DraftManager.Companion a;
  private static volatile DraftManager a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleDraftDraftManager$Companion = new DraftManager.Companion(null);
  }
  
  private final Cursor a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    String str = a();
    paramSQLiteDatabase = paramSQLiteDatabase.query("draft_info_table", new String[] { "draft_info" }, "key=? AND user_id=?", new String[] { paramString, str }, null, null, null);
    Intrinsics.checkExpressionValueIsNotNull(paramSQLiteDatabase, "db.query(\n        TABLE_…   null, null, null\n    )");
    return paramSQLiteDatabase;
  }
  
  private final String a(TweetTopicItem paramTweetTopicItem, OriginContentInfo paramOriginContentInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramTweetTopicItem != null) && (paramTweetTopicItem != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTweetTopicItem.a());
      localStringBuilder.append(paramTweetTopicItem.c());
      localJSONObject.putOpt("TweetTopic", localStringBuilder.toString());
    }
    if ((paramOriginContentInfo != null) && (paramOriginContentInfo != null)) {
      localJSONObject.putOpt("OriginContentInfo", paramOriginContentInfo.getOriginContentKey());
    }
    paramTweetTopicItem = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramTweetTopicItem, "jsonObject.toString()");
    return paramTweetTopicItem;
  }
  
  private final byte[] a(String paramString)
  {
    Object localObject = DatabaseHelper.a.a().getReadableDatabase();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "db");
    localObject = a((SQLiteDatabase)localObject, paramString);
    ((Cursor)localObject).moveToFirst();
    if (((Cursor)localObject).getCount() > 0) {
      paramString = ((Cursor)localObject).getBlob(((Cursor)localObject).getColumnIndex("draft_info"));
    } else {
      paramString = null;
    }
    ((Cursor)localObject).close();
    return paramString;
  }
  
  private final long b(String paramString, DraftArticleInfo paramDraftArticleInfo)
  {
    SQLiteDatabase localSQLiteDatabase = DatabaseHelper.a.a().getWritableDatabase();
    b(paramString);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("key", paramString);
    localContentValues.put("draft_info", SerializableKt.a((Serializable)paramDraftArticleInfo));
    localContentValues.put("user_id", a());
    return localSQLiteDatabase.insert("draft_info_table", null, localContentValues);
  }
  
  private final void b(String paramString)
  {
    DatabaseHelper.a.a().getWritableDatabase().delete("draft_info_table", "key=? AND user_id=?", new String[] { paramString, a() });
  }
  
  private final boolean b(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = DatabaseHelper.a.a().getReadableDatabase();
    Intrinsics.checkExpressionValueIsNotNull(localSQLiteDatabase, "db");
    paramString = a(localSQLiteDatabase, paramString);
    paramString.moveToFirst();
    boolean bool;
    if (paramString.getCount() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramString.close();
    return bool;
  }
  
  public final long a(@NotNull String paramString, @NotNull DraftArticleInfo paramDraftArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramDraftArticleInfo, "info");
    return b(paramString, paramDraftArticleInfo);
  }
  
  @Nullable
  public final DraftArticleInfo a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    paramString = a(paramString);
    if (paramString != null) {
      return (DraftArticleInfo)SerializableKt.a(paramString);
    }
    return null;
  }
  
  @NotNull
  public final String a()
  {
    String str = TopicSDKHelperKt.a().a();
    Intrinsics.checkExpressionValueIsNotNull(str, "account.userId");
    return str;
  }
  
  @NotNull
  public final String a(@Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject = null;
    if (paramGlobalPublisherConfig == null) {
      return a(null, null);
    }
    ArrayList localArrayList = paramGlobalPublisherConfig.getEditObjectListByOriginText();
    boolean bool = ((Collection)localArrayList).isEmpty();
    int i = 1;
    if ((!(bool ^ true)) || (((EditObject)localArrayList.get(0)).getType() != EditObject.EditObjectType.TYPE_TOPIC)) {
      i = 0;
    }
    if (i != 0)
    {
      localObject = localArrayList.get(0);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "editObjectList[0]");
      localObject = (EditObject)localObject;
      localObject = new TweetTopicItem(((EditObject)localObject).getId(), null, ((EditObject)localObject).getWording(), 0L, null, 26, null);
    }
    return a((TweetTopicItem)localObject, paramGlobalPublisherConfig.getOriginContentInfo());
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    b(paramString);
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager
 * JD-Core Version:    0.7.0.1
 */