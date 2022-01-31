class scs
  implements moc
{
  scs(scq paramscq, boolean paramBoolean) {}
  
  public void loaded(String paramString, int paramInt)
  {
    urk.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource loaded code = %d ", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    case -1: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      scq.a(this.jdField_a_of_type_Scq);
    }
    urk.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource download success", Integer.valueOf(paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     scs
 * JD-Core Version:    0.7.0.1
 */