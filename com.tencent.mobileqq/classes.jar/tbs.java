import android.database.Cursor;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.database.FeedEntry;
import com.tencent.biz.qqstory.database.HotTopicEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.database.MsgTabNodeEntity;
import com.tencent.biz.qqstory.database.OfficialRecommendEntry;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;
import com.tencent.biz.qqstory.database.ShareGroupListEntry;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.biz.qqstory.database.StoryAlbumPicEntry;
import com.tencent.biz.qqstory.database.StoryEntry;
import com.tencent.biz.qqstory.database.StoryVideoEntry;
import com.tencent.biz.qqstory.database.StoryVideoListEntry;
import com.tencent.biz.qqstory.database.StoryVideoSimpleInfoEntity;
import com.tencent.biz.qqstory.database.TopicInfoEntry;
import com.tencent.biz.qqstory.database.TroopStoryEntry;
import com.tencent.biz.qqstory.database.UnionIdMapEntity;
import com.tencent.biz.qqstory.database.UserEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabHaloEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeRecommendActivityReadEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tbs
  extends QQEntityManagerFactory
{
  public tbs(String paramString)
  {
    super(paramString);
  }
  
  public static void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    long l = System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.b(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {
          for (;;)
          {
            try
            {
              if (!str.equals(UserEntry.class.getSimpleName())) {
                continue;
              }
              localObject = UserEntry.class;
              aula.a(localArrayList, str, localCursor2, (Class)localObject);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Object localObject;
              veg.b("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange", localClassNotFoundException);
              continue;
            }
            localCursor2.close();
            break;
            if (str.equals(StoryEntry.class.getSimpleName())) {
              localObject = StoryEntry.class;
            } else if (str.equals(StoryVideoEntry.class.getSimpleName())) {
              localObject = StoryVideoEntry.class;
            } else if (str.equals(StoryVideoListEntry.class.getSimpleName())) {
              localObject = StoryVideoListEntry.class;
            } else if (str.startsWith(PublishVideoEntry.class.getSimpleName())) {
              localObject = PublishVideoEntry.class;
            } else if (str.equals(HotTopicEntry.class.getSimpleName())) {
              localObject = HotTopicEntry.class;
            } else {
              localObject = Class.forName(paramString + "." + str);
            }
          }
        }
      }
      localCursor1.close();
    }
    com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        paramSQLiteDatabase.execSQL((String)paramString.next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    }
    paramSQLiteDatabase.endTransaction();
    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    veg.a("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange take time:%d", Long.valueOf(System.currentTimeMillis() - l));
  }
  
  public void a()
  {
    a(this.mInnerDbHelper.getWritableDatabase());
    createDatabase(this.mInnerDbHelper.getWritableDatabase());
  }
  
  protected void a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(auln.a(StoryEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(StoryVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(StoryVideoListEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(UserEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(PublishVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(ReportWatchVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(VideoCollectionEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(MemoryInfoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(StoryVideoSimpleInfoEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(TroopStoryEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(CardEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(TopicInfoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(UnionIdMapEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(ShareGroupListEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(DiscoverBannerVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(MsgTabNodeEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(MsgTabHaloEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(MsgTabNodeVidListEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(DownloadingUrlEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(StoryAlbumPicEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(auln.a(StoryAlbumEntry.class.getSimpleName()));
  }
  
  public akfv build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "qqstory_" + paramString + ".db", null, 180);
      this.dbHelper = new akfv(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(auln.a(new UserEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new StoryEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new StoryVideoEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new StoryVideoListEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new PublishVideoEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new ReportWatchVideoEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new VideoCollectionEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new MemoryInfoEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new StoryVideoSimpleInfoEntity()));
    paramSQLiteDatabase.execSQL(auln.a(new TroopStoryEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new CardEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new TopicInfoEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new UnionIdMapEntity()));
    paramSQLiteDatabase.execSQL(auln.a(new ShareGroupListEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new DiscoverBannerVideoEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new MsgTabNodeEntity()));
    paramSQLiteDatabase.execSQL(auln.a(new MsgTabHaloEntity()));
    paramSQLiteDatabase.execSQL(auln.a(new MsgTabNodeVidListEntity()));
    paramSQLiteDatabase.execSQL(auln.a(new DownloadingUrlEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new MsgTabNodeRecommendActivityReadEntity()));
    paramSQLiteDatabase.execSQL(auln.a(new StoryAlbumPicEntry()));
    paramSQLiteDatabase.execSQL(auln.a(new StoryAlbumEntry()));
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      a(paramSQLiteDatabase);
      createDatabase(paramSQLiteDatabase);
      veg.d("Q.qqstory.QQStoryEntityManagerFactory", "Version %d turn to %d ,clear all data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    if (paramInt1 < 29)
    {
      paramSQLiteDatabase.execSQL(auln.a(PublishVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new PublishVideoEntry()));
    }
    if (paramInt1 < 70) {
      paramSQLiteDatabase.execSQL(auln.a("FirstVideoEntry"));
    }
    if (paramInt1 < 90)
    {
      paramSQLiteDatabase.execSQL(auln.a(TopicInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new TopicInfoEntry()));
    }
    if (paramInt1 < 98)
    {
      paramSQLiteDatabase.execSQL(auln.a(LikeEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new LikeEntry()));
      paramSQLiteDatabase.execSQL(auln.a(LiveVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new LiveVideoEntry()));
      paramSQLiteDatabase.execSQL(auln.a(MemoryInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new MemoryInfoEntry()));
      paramSQLiteDatabase.execSQL(auln.a(OfficialRecommendEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new OfficialRecommendEntry()));
      paramSQLiteDatabase.execSQL(auln.a(ReportWatchVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new ReportWatchVideoEntry()));
      paramSQLiteDatabase.execSQL(auln.a(UserEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new UserEntry()));
      paramSQLiteDatabase.execSQL(auln.a(StoryEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new StoryEntry()));
      paramSQLiteDatabase.execSQL(auln.a(StoryVideoListEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new StoryVideoListEntry()));
      paramSQLiteDatabase.execSQL(auln.a(VideoCollectionEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new VideoCollectionEntry()));
      paramSQLiteDatabase.execSQL(auln.a(UnionIdMapEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new UnionIdMapEntity()));
    }
    if (paramInt1 < 102)
    {
      paramSQLiteDatabase.execSQL(auln.a(CommentEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new CommentEntry()));
      paramSQLiteDatabase.execSQL(auln.a(TroopStoryEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new TroopStoryEntry()));
    }
    if (paramInt1 < 112)
    {
      paramSQLiteDatabase.execSQL(auln.a(CardEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new CardEntry()));
    }
    if (paramInt1 < 134)
    {
      paramSQLiteDatabase.execSQL(auln.a(FeedEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new FeedEntry()));
    }
    if (paramInt1 < 138)
    {
      paramSQLiteDatabase.execSQL(auln.a(StoryVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new StoryVideoEntry()));
    }
    if (paramInt1 < 138)
    {
      paramSQLiteDatabase.execSQL(auln.a(MemoryInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new MemoryInfoEntry()));
    }
    if (paramInt1 < 158)
    {
      paramSQLiteDatabase.execSQL(auln.a(MsgTabNodeRecommendActivityReadEntity.TABLE_NAME));
      paramSQLiteDatabase.execSQL(auln.a(new MsgTabNodeRecommendActivityReadEntity()));
      paramSQLiteDatabase.execSQL(auln.a(MsgTabNodeEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new MsgTabNodeEntity()));
      paramSQLiteDatabase.execSQL(auln.a(MsgTabNodeVidListEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new MsgTabNodeVidListEntity()));
    }
    if (paramInt1 < 178)
    {
      paramSQLiteDatabase.execSQL(auln.a(StoryVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new StoryVideoEntry()));
      paramSQLiteDatabase.execSQL(auln.a(StoryAlbumEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(new StoryAlbumEntry()));
    }
    a("com.tencent.biz.qqstory.database", paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbs
 * JD-Core Version:    0.7.0.1
 */