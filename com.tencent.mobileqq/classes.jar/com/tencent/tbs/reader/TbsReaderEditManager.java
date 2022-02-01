package com.tencent.tbs.reader;

import android.content.Context;
import com.tencent.tbs.reader.external.ITbsReaderEditAtom;
import com.tencent.tbs.reader.external.TbsReaderAdvAtom;

public class TbsReaderEditManager
  extends TbsReaderManager
{
  public static final String TAG = "TbsReaderManager";
  private TbsReaderAdvAtom mReaderAdvAtom = null;
  
  public void destroy()
  {
    super.destroy();
    TbsReaderAdvAtom localTbsReaderAdvAtom = this.mReaderAdvAtom;
    if (localTbsReaderAdvAtom != null) {
      localTbsReaderAdvAtom.destory();
    }
    this.mReaderAdvAtom = null;
  }
  
  public TbsReaderAdvAtom getEditAtom()
  {
    return this.mReaderAdvAtom;
  }
  
  public boolean initReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    this.mReaderCore = createReaderCore(paramContext, paramITbsReaderCallback, 1);
    if (this.mReader != null) {
      this.mReaderAdvAtom = new TbsReaderAdvAtom((ITbsReaderEditAtom)this.mReader.createAtom(2));
    }
    if (this.mReaderCore != null) {
      return this.mReaderCore.init(paramContext);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsReaderEditManager
 * JD-Core Version:    0.7.0.1
 */